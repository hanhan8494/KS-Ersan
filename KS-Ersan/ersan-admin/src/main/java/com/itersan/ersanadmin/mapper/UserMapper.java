package com.itersan.ersanadmin.mapper;

import com.itersan.ersanpojo.admin.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    User selectUserName(String username);
}
