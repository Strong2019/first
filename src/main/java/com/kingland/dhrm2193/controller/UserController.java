package com.kingland.dhrm2193.controller;

import com.kingland.dhrm2193.bean.User;
import com.kingland.dhrm2193.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * UserController
 *
 * @author Rooney
 * @version 1.0
 * @date 2020/7/27 9:35 AM
 * @description
 */
@Controller
public class UserController {
    /**
     * user Service
     */
    final UserService userService;

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
     * @param username user name
     * @param password password
     * @return view
     * @throws UsernameNotFoundException user name not found exception
     */
    @PostMapping("/register")
    public String regist(@RequestParam String username, @RequestParam String password) throws UsernameNotFoundException {
        // create a user object
        User user = new User();
        // set user name
        user.setUsername(username);
        // set password
        user.setPassword(password);
        // Call the register method of user service
        userService.register(user);
        // redirect to login page
        return "redirect:login";
    }
}
