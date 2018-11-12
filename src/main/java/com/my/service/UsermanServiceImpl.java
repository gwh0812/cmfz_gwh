package com.my.service;

import com.my.dao.UsermanDao;
import com.my.entity.Userman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsermanServiceImpl implements UsermanService {
    @Autowired
    private UsermanDao usermanDao;
    @Override
    /*插入*/
    public void insert(Userman userman) {
        usermanDao.select(userman);


    }
    /*查找*/
    @Override
    public Userman select(Userman userman) {
        return usermanDao.select(userman);
    }
    /*修改*/
    @Override
    public void update(Userman userman) {
        usermanDao.update(userman);
    }
}
