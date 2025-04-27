package com.itersan.ersanadmin;

import com.itersan.config.FastJson2JsonRedisSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ErsanAdminApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }
//    String
    @Test
    void testString(){
        redisTemplate.opsForValue().set("name","曾佳丽");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
    //序列化还不完善Hash和List类型的redis还有问题

    @Test
    void testUser(){
        redisTemplate.opsForValue().set("user:100",new User("韩信",18));
        User name = (User) redisTemplate.opsForValue().get("user:100");
        System.out.println(name);
    }
}
