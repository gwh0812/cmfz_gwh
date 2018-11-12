package com.my.controller;

import com.my.entity.Menu;
import com.my.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/MenuController")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/queryAll")
    public @ResponseBody List<Menu> queryAll(){
        return menuService.queryAll();
    }

}
