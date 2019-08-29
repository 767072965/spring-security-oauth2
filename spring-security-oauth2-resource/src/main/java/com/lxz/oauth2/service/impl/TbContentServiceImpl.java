package com.lxz.oauth2.service.impl;

import com.lxz.oauth2.dao.TbContentDao;
import com.lxz.oauth2.entity.TbContent;
import com.lxz.oauth2.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }
}
