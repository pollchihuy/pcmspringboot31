package com.juaracoding.pcmspringboot31.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:gurital.properties")
public class GuritaConfig {
    @Value("${gurita.goreng.name}")
    private String name;
    @Value("${gurita.goreng.price}")
    private String price;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
