package com.lxz.oauth2.dao;

import com.lxz.oauth2.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbUserDao {

    TbUser selectUserByName(@Param("username") String username);
}
