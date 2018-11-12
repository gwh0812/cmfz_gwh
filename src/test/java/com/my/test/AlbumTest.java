package com.my.test;

import com.my.dao.AlbumDao;
import com.my.entity.Album;
import com.my.entity.Chapter;
import com.my.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AlbumTest {
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private AlbumService albumService;

    /*------------------------------------------------查询所有-----------------------------------------------------------------*/
    @Test
    public void queryAll() {

        List<Album> albums = albumDao.queryAll();
        System.out.println(albums);
/*        for (Album album : albums) {
            System.out.println(album);
        }*/
    }
    /*-----------------------------------------------删除-----------------------------------------------------------------*/
    @Test
    public void insert(){
        Album album = new Album();
        album.setId(UUID.randomUUID().toString());
        album.setThumbnail("a");
        album.setTitle("a");
        album.setSet_count(1);
        album.setCreate_date(new Date());
        album.setScore(5);
        album.setAuthor("a");
        album.setBroadcast("a");
        album.setBiref("a");
        albumDao.insert(album);
    }
    @Test
    public void queryOne(){
        Album albums = albumDao.queryOne("1");
        int i=0;

            List<Chapter> children = albums.getChildren();
            for (Chapter s:children) {
                    if (s.getId()!=null){
                        i++;
                    }
            }
            albums.setSet_count(i);

        System.out.println(albums);
    }

    @Test
    public void test01(){
        Album album = albumService.queryOne("1");
        Integer set_count = album.getSet_count();
        System.out.println(set_count);
    }
}