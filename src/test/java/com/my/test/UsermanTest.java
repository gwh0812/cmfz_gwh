package com.my.test;

import com.my.dao.UsermanDao;
import com.my.entity.Album;
import com.my.entity.Userman;
import com.my.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UsermanTest {
    @Autowired
    private UsermanDao usermanDao;
    @Autowired
    private AlbumService albumService;

    /*------------------------------------------------查询所有-----------------------------------------------------------------*/
    @Test
    public void queryAll() {
        Userman userman = new Userman();
        userman.setUsername("1111");
        userman.setPassword("1111");

        System.out.println(usermanDao.select(userman));

    }
    /*-----------------------------------------------删除-----------------------------------------------------------------*/
    @Test
    public void insert(){
        Userman userman = new Userman();
        userman.setId("1");
        userman.setUsername("1111");
        userman.setPassword("1111");
        usermanDao.insert(userman);
    }
    @Test
    public void update(){
        Userman userman = new Userman();
        userman.setId("1");
        userman.setUsername("1111");
        userman.setPassword("2222");
        usermanDao.update(userman);
    }

    @Test
    public void test01(){
        Album album = albumService.queryOne("1");
        Integer set_count = album.getSet_count();
        System.out.println(set_count);
    }
}