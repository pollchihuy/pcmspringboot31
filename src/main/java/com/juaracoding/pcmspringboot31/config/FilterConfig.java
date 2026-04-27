package com.juaracoding.pcmspringboot31.config;
import com.juaracoding.pcmspringboot31.security.CustomHttpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomHttpFilter> customHttpFilter() {
        FilterRegistrationBean<CustomHttpFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomHttpFilter());
        registrationBean.addUrlPatterns("/*"); // Atur pola URL untuk disaring
        registrationBean.setOrder(1); // Atur urutan filter jika ada beberapa

        return registrationBean;
    }
}
