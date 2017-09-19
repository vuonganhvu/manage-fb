package com.higgsup;

import com.higgsup.interceptors.LoggingInterceptor;
import com.higgsup.interceptors.TransactionInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created on 19-Sep-17.
 * OwnerBy anhvu
 */

//@Configuration
//@ComponentScan("com.higgsup")
//@EnableWebMvc
public class Appconfig extends WebMvcConfigurerAdapter {

    public Appconfig() {
        System.out.println("Tao cau hinh 1");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST","PUT", "DELETE","OPTIONS")  ;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoggingInterceptor());
        registry.addInterceptor(new TransactionInterceptor()).addPathPatterns("/ad/*");
        System.out.println("lan 1");
//        registry.addInterceptor(new TransactionInterceptor()).addPathPatterns("/ad/*");
    }
}
