package com.kingland.dhrm2193.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * WebSecurityConfig
 *
 * @author Rooney
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * user info Service
     */
    private final UserDetailsService userService;

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
                .antMatchers("/public/**");
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
                .antMatchers("/register").permitAll()
                .antMatchers("/css/**").permitAll()
                // Only admin permission users are allowed to access the admin page
                .antMatchers("/admin").hasRole("ADMIN")
                // All requests except the above require authentication
                .anyRequest().authenticated().and()
                // Define the login page to go to when a user needs to log in
                .formLogin().loginPage("/login").defaultSuccessUrl("/index").permitAll().and()
                // Defining logout operations
                .logout().logoutSuccessUrl("/login").permitAll().and()
                // Disable CSRF, otherwise it may cause some errors
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
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}