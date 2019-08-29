package com.lxz.oauth2.service;

import com.lxz.oauth2.entity.TbPermission;

import java.util.List;

public interface TbPermissionService {

    List<TbPermission> getPermissionByUserId(Long userId);
}
