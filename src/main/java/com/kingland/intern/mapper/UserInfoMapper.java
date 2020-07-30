/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.mapper;

import com.kingland.intern.domain.Role;
import com.kingland.intern.domain.UserInfo;

import java.util.List;

/**
 * @author KSC
 * @description This file is the mapper of mybatis.
 */
public interface UserInfoMapper {
    /**
     * select user info by user name
     *
     * @param username user name
     * @return user object
     */
    UserInfo queryUserByName(String username);

    /**
     * add user
     *
     * @param record user
     * @return number of affected rows
     */
    int insert(UserInfo record);

    /**
     * query roles by user id
     *
     * @param userId user id
     * @return role list
     */
    List<Role> queryRolesByUserId(Long userId);

    /**
     * delete by primary key
     *
     * @param userId primary key userId
     * @return affected rows
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * insert selective
     *
     * @param record record
     * @return affected rows
     */
    int insertSelective(UserInfo record);

    /**
     * select by primary key
     *
     * @param userId primary key userId
     * @return user info
     */
    UserInfo selectByPrimaryKey(Long userId);

    /**
     * update by primary key selective
     *
     * @param record record
     * @return affected rows
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * update by primary key
     *
     * @param record record
     * @return affected rows
     */
    int updateByPrimaryKey(UserInfo record);
}
