/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.service;

import com.kingland.intern.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author KSC
 * @description This class is business logic code.
 */
public interface UserInfoService extends UserDetailsService {

    /**
     * override loadUserByUsername method
     *
     * @param username user name
     * @return user info
     */
    @Override
    public UserDetails loadUserByUsername(String username);

    /**
     * user register
     *
     * @param userInfo user
     */
    public Boolean register(UserInfo userInfo);
}