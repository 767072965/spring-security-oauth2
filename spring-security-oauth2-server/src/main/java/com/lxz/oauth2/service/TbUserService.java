package com.lxz.oauth2.service;

import com.lxz.oauth2.entity.TbUser;

public interface TbUserService {


    TbUser getUserByUsername(String username);
}
