/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.config;

import com.kingland.intern.common.Common;
import com.kingland.intern.utils.MyPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author KSC
 * @description web security configuration.
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * user info Service
     */
    private UserDetailsService userService;

    /**
     * Injection by construction method
     *
     * @param userService user Service
     */
    public WebSecurityConfig(UserDetailsService userService) {
        this.userService = userService;
    }

    /**
     * Rewrite configuration and filter static resources
     *
     * @param webSecurity web security
     */
    @Override
    public void configure(WebSecurity webSecurity) {
        // Allow access to all files in the /css directory
        webSecurity.ignoring().antMatchers("/favicon.ico", "/resources/**", "/error")
                .antMatchers("/public/css/**")
                .antMatchers("/*.html");
    }

    /**
     * Security policy configuration
     *
     * @param httpSecurity http security
     * @throws Exception exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                // Some resources of the website need to be authenticated
                .antMatchers("/register.html").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("*").permitAll()
                // Only admin permission users are allowed to access the admin page
                .antMatchers("/admin").hasRole("ADMIN")
                // All requests except the above require authentication
                .anyRequest().authenticated().and()
                // Define the login page to go to when a user needs to log in
                .formLogin().loginPage("/login").defaultSuccessUrl("/index.html").permitAll().and()
                // Defining logout operations
                .logout().logoutSuccessUrl("/login").permitAll().and()
                // Disable CSRF, make post request can be accessed. otherwise it may cause some errors
                .csrf().disable()
        ;
        // Disable cache
        httpSecurity.headers().cacheControl();
    }



    /**
     * configure security authentication
     *
     * @param auth authentication
     * @throws Exception exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Authentication through database
        auth.userDetailsService(userService).passwordEncoder(new MyPasswordEncoder(Common.SALT));
    }
}