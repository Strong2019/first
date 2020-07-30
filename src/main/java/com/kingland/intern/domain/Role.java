/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author KSC
 * @description role object
 */
@ApiModel(value = "role object", description = "role object")
public class Role {
    /**
     * role id
     */
    @NotNull
    @ApiModelProperty(value = "role id")
    private Long roleId;

    /**
     * role name
     */
    @NotNull
    @ApiModelProperty(value = "role name")
    private String roleName;

    public Role(@NotNull Long roleId, @NotNull String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
