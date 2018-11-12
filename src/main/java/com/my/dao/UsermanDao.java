package com.my.dao;

import com.my.entity.Userman;

public interface UsermanDao {
    /*插入*/
    void insert(Userman userman);
    /*查询*/
    Userman select(Userman userman);
    /*修改*/
    void update(Userman userman);
}
