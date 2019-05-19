package com.interview.demo.config;

import com.interview.demo.interceptor.LoginInterCerpotr;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigurerInterCeptor implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration r = registry.addInterceptor(new LoginInterCerpotr()).addPathPatterns("/business/**/");
        r.excludePathPatterns("/error").excludePathPatterns("/login");
    }
}
 