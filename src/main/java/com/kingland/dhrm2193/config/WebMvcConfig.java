package com.kingland.dhrm2193.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * url configurer
 *
 * It can be understood as simple access filtering and forwarding to the corresponding view page
 * @author Rooney
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * view configurer
     *
     * @param registry registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // login page
        registry.addViewController("/login").setViewName("login");
        // home page
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/hello").setViewName("index");
        registry.addViewController("/admin").setViewName("index");
    }
}