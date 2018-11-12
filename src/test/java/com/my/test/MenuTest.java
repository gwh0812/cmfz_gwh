package com.my.test;

import com.my.entity.Menu;
import com.my.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class MenuTest {
    @Autowired
    private MenuService menuService;
    @Test
    public void queryAll(){
        List<Menu> menus = menuService.queryAll();
        System.out.println(menus);
    }
}
