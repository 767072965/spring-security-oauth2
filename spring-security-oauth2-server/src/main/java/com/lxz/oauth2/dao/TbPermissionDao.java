package com.lxz.oauth2.dao;

import com.lxz.oauth2.entity.TbPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbPermissionDao {

    List<TbPermission> getPermissionByUserId(@Param("userId") Long userId);
}
