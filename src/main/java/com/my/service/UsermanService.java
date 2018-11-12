package com.my.service;

import com.my.entity.Userman;

public interface UsermanService {
    /*插入*/
    void insert(Userman userman);
    /*查询*/
    Userman select(Userman userman);
    /*修改*/
    void update(Userman userman);
}
