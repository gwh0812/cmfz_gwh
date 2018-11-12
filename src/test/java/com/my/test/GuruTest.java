package com.my.test;

import com.my.entity.Guru;
import com.my.service.GuruService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class GuruTest {
    @Autowired
    private GuruService guruServices;

    /*------------------------------------------------查询所有-----------------------------------------------------------------*/
    @Test
    public void queryAll(){

        System.out.println(guruServices.queryAll());
    }
    /*-----------------------------------------------删除-----------------------------------------------------------------*/
@Test
    public void delete(){
    guruServices.delete("1");
}

    /*-----------------------------------------------添加-----------------------------------------------------------------*/
    @Test
    public void insert(){
        Guru guru = new Guru();
        guru.setId("asda");
        guru.setHeadPic("2.jpg");
        guru.setName("aaa");
        guru.setStaus("on");
        guruServices.insert(guru);
    }
}
