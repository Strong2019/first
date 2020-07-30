/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.mapper;

import com.kingland.intern.domain.RelationUserRole;

/**
 * @author KSC
 * @description insert the relationship between user and role to the table
 */
public interface RelationUserRoleMapper {

    /**
     * insert the relationship between user and role to the table
     *
     * @param record record
     * @return affected rows
     */
    int insert(RelationUserRole record);
}