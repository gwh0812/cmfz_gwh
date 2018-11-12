package com.my.controller;

import com.my.entity.Chapter;
import com.my.service.ChapterService;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/ChapterController")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(HttpServletRequest request, MultipartFile addalbumtxt, Chapter chapter) throws Exception {
        String chapterTxt = request.getSession().getServletContext().getRealPath("/ChapterTxt");
        long size = addalbumtxt.getSize();
        double v = size / 1024.0 / 1024.0;
        DecimalFormat decimalFormat = new DecimalFormat();
        chapter.setId(UUID.randomUUID().toString());
        chapter.setMemory(decimalFormat.format(v)+"MB");
        chapter.setDownload_url(addalbumtxt.getOriginalFilename());

        /*----------------上传文件-------------------*/
        addalbumtxt.transferTo(new File(chapterTxt,addalbumtxt.getOriginalFilename()));
        /*------------获取音频的时间长度--------------*/

        File file = new File(chapterTxt,addalbumtxt.getOriginalFilename());
        MP3File f = (MP3File)AudioFileIO.read(file);
        MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
        String trackLength = audioHeader.getTrackLength()/360+":"+audioHeader.getTrackLength()/60+":"+audioHeader.getTrackLength()%60;
        chapter.setDuration(trackLength);

        chapterService.insert(chapter);
        /*-----------------------------------------------------------*/
        HashMap<String, Object> results = new HashMap<>();
        try {
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
/*------------------------------------------------下载---------------------------------------------------------------------*/
    }
    @RequestMapping("/download")
    public void download(String fileName,String openStyle,HttpServletRequest request,HttpServletResponse response) throws Exception{

        //1.根据接收的文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("" +
                "");
        //2.以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath,fileName));
        //2.1 设置响应头
        response.setHeader("content-disposition", openStyle+";fileName="+URLEncoder.encode(fileName, "UTF-8"));
        //3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //4.使用IOUtils工具类
        IOUtils.copy(is, os);
        //5.关流
        IOUtils.closeQuietly(is);//安静关流
        IOUtils.closeQuietly(os);

    }

}
