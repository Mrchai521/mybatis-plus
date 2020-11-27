package com.cxf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author xfchai
 * @ClassName MybatisApplication.java
 * @Description TODO
 * @createTime 2020/11/26 10:54:00
 */
@SpringBootApplication
@MapperScan("com.cxf.mapper")
public class MybatisApplication {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(MybatisApplication.class, args);
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println("http://localhost:" + applicationContext.getEnvironment().getProperty("server.port"));
    }
}
