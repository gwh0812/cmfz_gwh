package com.my.service;

import com.my.dao.GuruDao;
import com.my.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class GuruServiceImpl implements GuruService{
    @Autowired
    private GuruDao guruDao;
    /*------------------------------------------------查询所有-----------------------------------------------------------------*/
    @Override
    public List<Guru> queryAll() {
        return guruDao.queryAll();
    }
    /*------------------------------------------------删除-----------------------------------------------------------------*/
    @Override
    public void delete(String id) {
    guruDao.delete(id);
    }
    /*------------------------------------------------插入-----------------------------------------------------------------*/
    @Override
    public void insert(Guru guru) {
    guruDao.insert(guru);
    }
}
