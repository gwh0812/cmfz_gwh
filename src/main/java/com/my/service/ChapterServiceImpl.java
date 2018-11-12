package com.my.service;

import com.my.dao.ChapterDao;
import com.my.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;
    @Override
    public void insert(Chapter chapter) {
        chapterDao.insert(chapter);
    }
}
