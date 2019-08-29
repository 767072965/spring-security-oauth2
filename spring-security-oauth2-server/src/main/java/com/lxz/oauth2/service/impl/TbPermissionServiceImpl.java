package com.lxz.oauth2.service.impl;

import com.lxz.oauth2.dao.TbPermissionDao;
import com.lxz.oauth2.entity.TbPermission;
import com.lxz.oauth2.service.TbPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {


    @Autowired
    private TbPermissionDao tbPermissionDao;


    @Override
    public List<TbPermission> getPermissionByUserId(Long userId) {
        return tbPermissionDao.getPermissionByUserId(userId);
    }
}
