/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.service;

import com.kingland.intern.common.Common;
import com.kingland.intern.common.exception.user.UnknownException;
import com.kingland.intern.common.exception.user.UserDoesExistsException;
import com.kingland.intern.domain.User;
import com.kingland.intern.mapper.UserMapper;
import com.kingland.intern.utils.MyPasswordEncoder;
import com.kingland.intern.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KSC
 * @description This class is business logic code.
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {

    /**
     * user Mapper
     */
    private UserMapper userMapper;

    /**
     * injection by construction method
     *
     * @param userMapper user Mapper
     */
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * override loadUserByUsername method
     *
     * @param username user name
     * @return user info
     * @throws UsernameNotFoundException user name not found exception
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // list is used to save permissions
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        // query user info by username
        User user = userMapper.queryUserByName(username);
        // if user is null, throw usernameNotFoundException
        Utils.isNull(user);
        // Traverse add permission
        for (String s : user.getRole().split(Common.SPACE)) {
            // add permission to list
            list.add(new SimpleGrantedAuthority("ROLE_" + s));
        }
        // Return the user object with permission information
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), list);
    }

    /**
     * user register
     *
     * @param user user
     */
    public void register(User user) {
        // Query whether there is a user with the same name in the database
        User temp = userMapper.queryUserByName(user.getUsername());
        // If the user name is already occupied
        if (null != temp) {
            throw new UserDoesExistsException();
        }
        MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder(Common.SALT);
        // use myPasswordEncoder to strengthen password
        user.setPassword(myPasswordEncoder.encodePurePassword(user.getPassword()));
        // set the basic field for user register
        Utils.setUser(user);
        // If the insertion of the database fails, throw exception
        if (userMapper.addUser(user) != 1) {
            throw new UnknownException();
        }
    }
}