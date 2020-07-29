/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.controller;

import com.kingland.intern.domain.User;
import com.kingland.intern.service.UserService;
import com.kingland.intern.utils.AjaxResult;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author KSC
 * @description restful style url
 */
@RestController
@RequestMapping("/v1")
public class UserController {
    /**
     * user Service
     */
    private UserService userService;

    /**
     * Injection by construction method
     *
     * @param userService user Service
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * register page
     *
     * the return value type is string, the corresponding view will be returned
     * @return view
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * register function
     *
     * @return view
     * @throws UsernameNotFoundException user name not found exception
     */
    @PostMapping("/register")
    public AjaxResult register(@RequestBody @Valid User user) throws UsernameNotFoundException {
        // Call the register method of user service
        userService.register(user);
        // redirect to login page
        return AjaxResult.success("register successful!");
    }
}
