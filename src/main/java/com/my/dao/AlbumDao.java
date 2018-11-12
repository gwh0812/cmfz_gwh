package com.my.dao;

import com.my.entity.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> queryAll();
    void insert(Album album);
    Album queryOne(String id);
}
