package com.itersan.ersanadmin.service.impl;

import com.itersan.core.redis.RedisCache;
import com.itersan.ersanadmin.service.LoginService;
import com.itersan.ersanpojo.admin.LoginUser;
import com.itersan.ersanpojo.admin.User;
import com.itersan.result.ResponseResult;
import com.itersan.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    //登录用户
    public ResponseResult login(User user) {
        //Authent   进行用户认证
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        //如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败，密码错误");
        }

        //如果认证通过了，使用userid生成一个JWT jwt存入ResponseResult进行返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //把完整的用户信息存入redis  userid作为key
        redisCache.setCacheObject("itersan:user:login:" + userId, loginUser);
        //JDK高版本
        return new ResponseResult(200,"登陆成功", Map.of( "token", jwt));
    }

    //退出用户登录
    public ResponseResult loginout() {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        //删除redis中的userid信息
        redisCache.deleteObject("itersan:user:login:"+userid);

        return new ResponseResult(200,"退出成功");
    }
}
