/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.service.impl;

import com.kingland.intern.common.Common;
import com.kingland.intern.common.exception.user.UnknownException;
import com.kingland.intern.common.exception.user.UserDoesExistsException;
import com.kingland.intern.domain.RelationUserRole;
import com.kingland.intern.domain.Role;
import com.kingland.intern.domain.UserInfo;
import com.kingland.intern.mapper.RelationUserRoleMapper;
import com.kingland.intern.mapper.UserInfoMapper;
import com.kingland.intern.service.UserInfoService;
import com.kingland.intern.utils.MyPasswordEncoder;
import com.kingland.intern.utils.Utils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KSC
 * @description
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    /**
     * user Mapper
     */
    private UserInfoMapper userInfoMapper;

    /**
     * relation mapper
     */
    private RelationUserRoleMapper relationMapper;

    /**
     * injection by construction method
     *
     * @param userInfoMapper user Mapper
     * @param relationMapper relation mapper
     */
    @SuppressWarnings("all")
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper, RelationUserRoleMapper relationMapper) {
        this.userInfoMapper = userInfoMapper;
        this.relationMapper = relationMapper;
    }

    /**
     * override loadUserByUsername method
     *
     * @param username user name
     * @return user info
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // list is used to save permissions
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        // query user info by username
        UserInfo userInfo = userInfoMapper.queryUserByName(username);
        // if user is null, throw usernameNotFoundException
        Utils.isNull(userInfo);
        // query what permissions user has
        List<Role> roleList = userInfoMapper.queryRolesByUserId(userInfo.getUserId());
        // Traverse add permission
        for (Role r : roleList) {
            // add permission to list
            list.add(new SimpleGrantedAuthority("ROLE_" + r.getRoleName()));
        }
        // Return the user object with permission information
        return new org.springframework.security.core.userdetails.User(userInfo.getUsername(), userInfo.getPassword(), list);
    }

    /**
     * user register, if it occur an exception , rollback
     *
     * @param userInfo user
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(UserInfo userInfo) throws UnknownException, UserDoesExistsException {
        // Query whether there is a user with the same name in the database
        UserInfo temp = userInfoMapper.queryUserByName(userInfo.getUsername());
        // If the user name is already occupied
        if (null != temp) {
            throw new UserDoesExistsException();
        }
        MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder(Common.SALT);
        // use myPasswordEncoder to strengthen password
        userInfo.setPassword(myPasswordEncoder.encodePurePassword(userInfo.getPassword()));
        // If the insertion of the database fails, throw exception
        if (userInfoMapper.insert(userInfo) != 1) {
            throw new UnknownException();
        }
        // insert user role into table
        RelationUserRole relation = new RelationUserRole(com.kingland.intern.enums.Role.COMMON.getId(), userInfo.getUserId());
        if (relationMapper.insert(relation) != 1) {
            throw new UnknownException();
        }
        return true;
    }
}
