package com.my.service;

import com.my.dao.AlbumDao;
import com.my.entity.Album;
import com.my.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public List<Album> queryAll() {
        return albumDao.queryAll();
    }

    @Override
    public void insert(Album album) {
        albumDao.insert(album);
    }

    @Override
    public Album queryOne(String id) {
        Album albums = albumDao.queryOne("1");
        int i = 0;

            List<Chapter> children = albums.getChildren();
            for (Chapter s : children) {
                if (s.getId() != null) {
                    i++;
                }
            }
            albums.setSet_count(i);
        System.out.println(i);
        return albums;
    }

}

