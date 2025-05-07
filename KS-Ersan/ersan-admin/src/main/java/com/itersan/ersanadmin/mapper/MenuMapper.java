package com.itersan.ersanadmin.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    //根据userId查询权限信息
    List<String> selectPermsByUserId(Long userId);
}
