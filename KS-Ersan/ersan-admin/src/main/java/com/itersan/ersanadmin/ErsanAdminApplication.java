package com.itersan.ersanadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.itersan") //全局扫包
@MapperScan("com.itersan.ersanadmin.mapper") //扫Mapper包
@EnableConfigurationProperties //启用对 @ConfigurationProperties 注解的支持
public class ErsanAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErsanAdminApplication.class, args);
    }

}
