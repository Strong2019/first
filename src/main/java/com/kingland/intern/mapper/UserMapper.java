/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.mapper;

import com.kingland.intern.domain.User;

/**
 * @author KSC
 * @description This file is the mapper of mybatis.
 */
public interface UserMapper {
    /**
     * select user info by user name
     *
     * @param username user name
     * @return user object
     */
    User queryUserByName(String username);

    /**
     * add user
     *
     * @param user user
     * @return number of affected rows
     */
    int addUser(User user);


}
