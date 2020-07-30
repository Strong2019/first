/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * InternApplication
 *
 * @author KSC
 * @description This class is the boot application of the project.
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.kingland.intern.mapper")
public class InternApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternApplication.class, args);
    }

}
