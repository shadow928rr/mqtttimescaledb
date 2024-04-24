package com.guo.mqtttimescaledb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.guo.mqtttimescaledb.mapper")
public class MqtttimescaledbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqtttimescaledbApplication.class, args);
    }

}
