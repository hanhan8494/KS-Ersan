package com.itersan.ersanadmin;

import com.itersan.config.FastJson2JsonRedisSerializer;
import com.itersan.ersanadmin.mapper.UserMapper;
import com.itersan.ersanpojo.admin.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ErsanAdminApplicationTests {
//    @Autowired
//    private RedisTemplate redisTemplate;

        @Autowired
        private UserMapper userMapper;
    @Test
    void contextLoads() {
    }
//    String
//    @Test
//    void testString(){
//        redisTemplate.opsForValue().set("name","曾佳丽");
//        Object name = redisTemplate.opsForValue().get("name");
//        System.out.println(name);
//    }
    //序列化还不完善Hash和List类型的redis还有问题

//    @Test
//    void testUser(){
//        redisTemplate.opsForValue().set("user:100",new User("韩信",18));
//        User name = (User) redisTemplate.opsForValue().get("user:100");
//        System.out.println(name);
//    }
//
//    @Test
//    void testHash(){
//        redisTemplate.opsForHash().put("user:500","name","黄子宣");
//        redisTemplate.opsForHash().put("user:500","age",18);
//        Map entries = redisTemplate.opsForHash().entries("user:500");
//        System.out.println(entries);
//    }

    @Test
    void testHash(){
        User user = userMapper.selectUserName("ersan");
        System.out.println(user);
    }

    @Test
    void testHashg(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encode = encoder.encode("123456");
//        String encode1 = encoder.encode("123456");
        boolean matches = encoder.matches("123456", "$2a$10$fPQl2wTjLPzJRee2.i78VeNX9avHbFsxEmnojA1ywNYufgbSDmSL6");
        System.out.println(matches);
    }



}
