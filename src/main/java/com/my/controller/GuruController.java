package com.my.controller;

import com.my.entity.Guru;
import com.my.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/GuruController")
public class GuruController {
    @Autowired
    private GuruService guruService;
    /*-----------------------------------------------查询所有-----------------------------------------------------------------*/
    @RequestMapping("/queryAll")
    public @ResponseBody  List<Guru> queryAll(){
        /*调取查询方法，并将查询出来的值返回到页面*/
        return guruService.queryAll();
    }
    /*-----------------------------------------------删除-----------------------------------------------------------------*/
    @RequestMapping("/delete")
    public @ResponseBody  void delete(String id){
        /*更据页面传过来的id调用删除方法*/
        guruService.delete(id);
    }

    /*-----------------------------------------------添加-----------------------------------------------------------------*/
    @RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(Guru guru, HttpServletRequest httpServletRequest, MultipartFile addguruimg) throws IOException {
        /*获取你要存图面的文件夹的绝对路经*/
        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/img");
        /*将图片存到这个路径中*/
        addguruimg.transferTo(new File(realPath,addguruimg.getOriginalFilename()));
        /*将图片的名字及格式存到guru对象中*/
        guru.setHeadPic(addguruimg.getOriginalFilename());
        /*将UUID存到这个歌对象中*/
        guru.setId(UUID.randomUUID().toString());
        /*调用插入方法将这个对象存到数据库中*/
        guruService.insert(guru);
        /*新获取一个map集合*/
        HashMap<String, Object> results = new HashMap<>();
        try {
            /*没有异常就将true存到这个map集合中*/
            results.put("success",true);
        }catch (Exception e){
            /*如果有异常就将false存到map集合里*/
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }

        /*将map集合返回到页面*/
        return results;
    }
    /*-----------------------------------------------批量删除--------------------------------------------------------------------*/
    @RequestMapping("/deleteAll")
    public @ResponseBody void deleteAll(String[] id){
        /*遍历页面传过来的集合依次调用删除方法*/
        for (String s:id) {
            guruService.delete(s);
        }
    }
}
