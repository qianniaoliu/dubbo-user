package com.iu.sl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/6/3 21:58
 */
@SpringBootApplication
@MapperScan("com.iu.sl.mapper")
public class DubboUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboUserApplication.class,args);
    }
}
