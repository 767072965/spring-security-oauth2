package com.lxz.oauth2.service.impl;

import com.lxz.oauth2.dao.TbUserDao;
import com.lxz.oauth2.entity.TbUser;
import com.lxz.oauth2.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser getUserByUsername(String username) {
        return tbUserDao.selectUserByName(username);
    }
}
