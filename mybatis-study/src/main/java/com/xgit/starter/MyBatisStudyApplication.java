package com.xgit.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by tianxuanxuan
 * On 2020-08-31 16:41
 */

@SpringBootApplication
@EnableTransactionManagement
public class MyBatisStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisStudyApplication.class, args);
    }
}
