package com.my.service;

import com.my.entity.Guru;

import java.util.List;

public interface GuruService {
    List<Guru> queryAll();
    void delete (String id);
    void insert (Guru guru);
}
