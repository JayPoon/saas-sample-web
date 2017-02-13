package com.infinitus.saas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by administrator on 17/2/7.
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.infinitus.saas.mapper", sqlSessionFactoryRef = "sqlSessionFactory")

public class Application extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(new Class[]{com.infinitus.saas.Application.class});
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}