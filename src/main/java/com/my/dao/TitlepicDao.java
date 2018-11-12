package com.my.dao;

import com.my.entity.Titlepic;

import java.util.List;

public interface TitlepicDao {
    List<Titlepic> queryAll();
    void delete(String id);
    void insert(Titlepic titlepic);
}
