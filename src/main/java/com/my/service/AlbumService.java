package com.my.service;

import com.my.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> queryAll();
    void insert(Album album);
    Album queryOne(String id);
}
