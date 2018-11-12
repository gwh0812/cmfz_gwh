package com.my.service;

import com.my.dao.UserDao;
import com.my.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) {
    return userDao.select(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);

    }
}
