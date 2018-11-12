package com.my.test;

import com.my.dao.ChapterDao;
import com.my.entity.Chapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class chapterTest {
    @Autowired
    private ChapterDao chapterDao;

    /*------------------------------------------------查询所有-----------------------------------------------------------------*/
    @Test
    public void queryAll() {

/*        List<Album> albums = chapter.queryAll();
        System.out.println(albums);
*//*        for (Album album : albums) {
            System.out.println(album);
        }*/
    }
    /*-----------------------------------------------添加-----------------------------------------------------------------*/
    @Test
    public void insert(){
        Chapter chapter = new Chapter();
        chapter.setId("6");
        chapter.setTitle("a");
        chapter.setMemory("a");
        chapter.setDuration("a");
        chapter.setDownload_url("a");
        chapter.setAlbum_id("a");
        chapterDao.insert(chapter);
    }
}