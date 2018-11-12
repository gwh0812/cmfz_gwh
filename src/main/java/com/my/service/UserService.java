package com.my.service;

import com.my.entity.User;

public interface UserService {
    User login(User user);
    void update(User user);
}
