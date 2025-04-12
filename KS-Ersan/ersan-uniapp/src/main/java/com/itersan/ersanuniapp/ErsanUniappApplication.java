package com.itersan.ersanuniapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.itersan")
public class ErsanUniappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErsanUniappApplication.class, args);
    }

}
