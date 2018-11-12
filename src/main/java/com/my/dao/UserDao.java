package com.my.dao;

import com.my.entity.User;

public interface UserDao {
    User select(User user);
    void update(User user);
}
