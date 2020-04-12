package com.javashitang.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: lilimin
 * @Date: 2019/8/24 11:20
 */
@Configuration
public class DemoWebMvcConfigurerAdapter extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SystemInterceptor());
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login");
        registry.addInterceptor(new AuthorityInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login");
    }
}
