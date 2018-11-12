package com.my.dao;

import com.my.entity.Guru;

import java.util.List;

public interface GuruDao {
    List<Guru> queryAll();
    void delete(String id);
    void insert(Guru guru);

}
