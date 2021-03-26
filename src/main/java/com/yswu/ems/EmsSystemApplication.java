package com.yswu.ems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yswu.ems.dao")
public class EmsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmsSystemApplication.class, args);
    }

}
