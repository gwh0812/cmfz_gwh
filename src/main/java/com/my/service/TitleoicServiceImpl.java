package com.my.service;

import com.my.dao.TitlepicDao;
import com.my.entity.Titlepic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*---------------------------------------------------------------------------------------------------------------------*/
@Service
@Transactional
public class TitleoicServiceImpl implements TitlepicService{
    /*---------------------------------------------------------------------------------------------------------------------*/

    @Autowired
    private TitlepicDao titlepicDao;
    /*-------------------------------------------展示--------------------------------------------------------------------------*/
    @Override
    public List<Titlepic> queryAll() {
        return titlepicDao.queryAll();
    }
    /*--------------------------------------------删除-------------------------------------------------------------------------*/
    @Override
    public void delete(String id) {
        titlepicDao.delete(id);
    }
    /*--------------------------------------------添加-------------------------------------------------------------------------*/
    @Override
    public void insert(Titlepic titlepic) {
    titlepicDao.insert(titlepic);
    }


}
