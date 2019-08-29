package com.lxz.oauth2.dao;

import com.lxz.oauth2.entity.TbContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbContentDao {

    List<TbContent> selectAll();
}
