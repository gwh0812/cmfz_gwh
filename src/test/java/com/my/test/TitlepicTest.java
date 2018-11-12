package com.my.test;

import com.my.entity.Titlepic;
import com.my.service.TitlepicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TitlepicTest {
    @Autowired
    private TitlepicService titlepicService;
    /*-------------------------------------------------查询所有----------------------------------------------------------------*/
    @Test
    public void queryAll(){
        List<Titlepic> titlepics = titlepicService.queryAll();
        System.out.println(titlepics);
    }
    /*-----------------------------------------------------删除------------------------------------------------------------*/
    @Test
    public void delete(){
        titlepicService.delete("0");
    }
    /*-----------------------------------------------------添加------------------------------------------------------------*/
    @Test
    public void insert(){
        Titlepic titlepic = new Titlepic();
        titlepic.setId("120");
        titlepic.setThumbnail("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        titlepic.setContent("asdad");
        titlepic.setStatus("asdad");
        titlepic.setDate(new Date());
        titlepicService.insert(titlepic);
    }
}
