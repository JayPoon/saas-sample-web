package com.infinitus.saas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by administrator on 17/2/14.
 */
@Component
public class ConfigHolder {

    @Value("${spring.datasource.url}")
    private String dsurl;

    @PostConstruct
    public void init(){
        System.out.println("DEBUG ==== spring.datasource.url=" + dsurl);
    }

}
