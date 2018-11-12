package com.my.controller;

import com.my.entity.Userman;
import com.my.service.UsermanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/UsermanController")
public class UsermanController {
    @Autowired
    private UsermanService usermanService;
    /*注册*/
     @RequestMapping("/regist")
    public Map<String,Object> regist(Userman userman) {
         Userman select = usermanService.select(userman);

         HashMap<String, Object> map = new HashMap<>();
         if (select.equals(userman)){
             userman.setId(UUID.randomUUID().toString());
             usermanService.insert(userman);
             map.put("success",true);
         }else {
             map.put("success", false);
         }
         return map;
     }
     /*登录*/
     @RequestMapping("/login")
    public Map<String,Object> login(Userman userman){
         Userman select = usermanService.select(userman);
         HashMap<String, Object> map = new HashMap<>();
         if (select.equals(userman)){
                map.put("success",true);
         }else{
             map.put("success",false);
         }
         return map;
     }
     /*修改*/
     @RequestMapping("/update")
    public Map<String,Object> update(Userman userman){
         Userman select = usermanService.select(userman);
         HashMap<String, Object> map = new HashMap<>();
         if (select.equals(userman)){
             usermanService.update(userman);
             map.put("success",true);
         }else{
             map.put("success",false);
         }
         return map;
     }
}
