package com.itersan.ersanadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.itersan") //全局扫包
public class ErsanAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErsanAdminApplication.class, args);
    }

}
