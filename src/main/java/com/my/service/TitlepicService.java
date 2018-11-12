package com.my.service;

import com.my.entity.Titlepic;

import java.util.List;

public interface TitlepicService {
    List<Titlepic> queryAll();
    void delete(String id);
    void insert(Titlepic titlepic);
 }
