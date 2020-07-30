/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author KSC
 * @description the relation between user and role
 */
@ApiModel(value = "relation object", description = "relation object")
public class RelationUserRole {
    /**
     * role id
     */
    @NotNull
    @ApiModelProperty(value = "role id")
    private Long roleId;

    /**
     * user id
     */
    @NotNull
    @ApiModelProperty(value = "user id")
    private Long userId;

    public RelationUserRole(@NotNull Long roleId, @NotNull Long userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public RelationUserRole() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
