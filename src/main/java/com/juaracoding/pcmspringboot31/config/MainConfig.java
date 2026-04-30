package com.juaracoding.pcmspringboot31.config;


import com.juaracoding.pcmspringboot31.security.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Random;

@Configuration
public class MainConfig{

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public DataSource getDataSourceBuilder(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(Crypto.performDecrypt(env.getProperty("spring.datasource.url")));
        dataSourceBuilder.username(Crypto.performDecrypt(env.getProperty("spring.datasource.username")));
        dataSourceBuilder.password(Crypto.performDecrypt(env.getProperty("spring.datasource.password")));
        dataSourceBuilder.driverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return dataSourceBuilder.build();
    }

    @Bean
    public Random getRandom(){
        return new Random();
    }

}
