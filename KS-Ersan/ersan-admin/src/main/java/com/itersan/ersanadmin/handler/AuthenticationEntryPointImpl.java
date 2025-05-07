package com.itersan.ersanadmin.handler;

import com.alibaba.fastjson2.JSON;
import com.itersan.result.ResponseResult;
import com.itersan.utils.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // 创建响应结果对象
        ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "认证失败账号或密码错误,请重新登录!");
        // 将结果对象转换为 JSON 字符串
        String json = JSON.toJSONString(result);
        // 向响应中写入 JSON 字符串
        WebUtils.renderString(response, json);
    }
}