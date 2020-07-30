/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.domain;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KSC
 * @description role object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
