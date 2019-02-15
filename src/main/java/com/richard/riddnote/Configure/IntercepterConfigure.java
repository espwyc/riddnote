package com.richard.riddnote.Configure;

import com.richard.riddnote.Intercepter.SessionIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IntercepterConfigure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionIntercepter()).addPathPatterns("/**").excludePathPatterns("/login/**");
    }
}
