package com.my.test;

import com.my.entity.User;
import com.my.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public void Login(){
        User user = new User();
        user.setId(1);
        user.setUsername("aa");
        user.setPassword("123456");
        userService.login(user);
    }
    @Test
    public void Update(){
        User user = new User();
        user.setId(1);
        user.setUsername("aaa");
        user.setPassword("123456");
        userService.update(user);

    }
}
