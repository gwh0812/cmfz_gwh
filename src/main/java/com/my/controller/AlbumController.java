package com.my.controller;

import com.my.entity.Album;
import com.my.service.AlbumService;
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
@RequestMapping("/AlbumController")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    /*-------------------------------------------------展示所有---------------------------------------------------------------*/
    @RequestMapping("/queryAll")

    public @ResponseBody List<Album> queryAll(){
        System.out.println(albumService.queryAll());
        return albumService.queryAll();

    }
    /*-------------------------------------------------添加---------------------------------------------------------------*/
    @RequestMapping("/insert")
    public @ResponseBody Map<String,Object> insert(Album album, HttpServletRequest httpServletRequest, MultipartFile addalbumimg) throws IOException {
        String realPath = httpServletRequest.getSession().getServletContext().getRealPath("/albumpic");
        addalbumimg.transferTo(new File(realPath,addalbumimg.getOriginalFilename()));

        album.setThumbnail(addalbumimg.getOriginalFilename());
        album.setId(UUID.randomUUID().toString());
        album.setCreate_date(new Date());
        albumService.insert(album);
        HashMap<String, Object> results = new HashMap<>();
        try {
                results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("queryOne")
    public @ResponseBody Album queryOne(String id){
        System.out.println("1111111111111111");
        System.out.println(albumService.queryOne(id));
        return albumService.queryOne(id);

    }
    }

