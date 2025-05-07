package com.itersan.ersanadmin.service;

import com.itersan.ersanpojo.admin.User;
import com.itersan.result.ResponseResult;

public interface LoginService {

    //登录用户
    ResponseResult login(User user);

    //退出登录
    ResponseResult loginout();
}
