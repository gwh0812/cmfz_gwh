package com.my.controller;

import com.my.entity.Titlepic;
import com.my.service.TitlepicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/TitlepicController")
public class TitlepiccController {
    @Autowired
    private TitlepicService titlepicService;
/*-------------------------------------------------展示所有-------------------------------------------------------------------*/
    @RequestMapping("/queryAll")
    public @ResponseBody List<Titlepic> queryAll(){
        /*调用查询方法将所有数据查询出来并返回到页面*/
        return titlepicService.queryAll();
    }
    /*-------------------------------------------------按条件删除-------------------------------------------------------------------*/
    @RequestMapping("/delete")
    public @ResponseBody void delete(String id){
        /*更据页面传过来的id执行删除单行数据的方法*/
    titlepicService.delete(id);
    }
    /*-----------------------------------------------批量删除--------------------------------------------------------------------*/
    @RequestMapping("/deleteAll")
    public @ResponseBody void deleteAll(String[] id){
        /*遍历更据页面错过来的集合，依次调用删除单个的方法*/
        for (String s:id) {
            titlepicService.delete(s);
        }
    }
    /*-----------------------------------------------添加--------------------------------------------------------------------*/
    @RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(HttpServletRequest httpServletRequest,  MultipartFile imgpath, Titlepic titlepic) throws IOException {
       /*获取你将图片存在文件夹的绝对路径*/
       String realPath=httpServletRequest.getSession().getServletContext().getRealPath("/image");
       /*将图片上传到个路径中*/
        imgpath.transferTo(new File(realPath,imgpath.getOriginalFilename()));
        /*在将图片的路径存到titlepic对象中*/
        titlepic.setThumbnail(imgpath.getOriginalFilename());
        /*给id字段一个uuid插入到titlepic对象中*/
        titlepic.setId(UUID.randomUUID().toString());
        /*新获取一个系统时间插入到titlepic对象中*/
        titlepic.setDate(new Date());
        /*新获取一个map集合*/
        Map<String,Object> results = new HashMap<String,Object>();
        /*调用插入方法将titlepic对象存到数据库中*/
        titlepicService.insert(titlepic);
        try {
            /*如果没有异常就在map集合中存一个true*/
            results.put("success", true);
        }catch (Exception e){
            e.printStackTrace();
            /*如果有异常就在map集合中存一个false*/
            results.put("success",false);
            /*打印异常信息*/
            results.put("message",e.getMessage());

        }
        /*将map集合返回到页面*/
        return results;
    }
}
