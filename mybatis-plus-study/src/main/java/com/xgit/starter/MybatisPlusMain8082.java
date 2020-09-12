package com.xgit.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by tianxuanxuan
 * On 2020-09-12 17:39
 */
@SpringBootApplication
@MapperScan("com.xgit")
public class MybatisPlusMain8082 {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusMain8082.class, args);
    }
}
