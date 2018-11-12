package com.my.service;

import com.my.dao.MenuDao;
import com.my.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> queryAll() {
        return menuDao.queryAll();
    }
}
