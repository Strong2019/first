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
 * @description the relation between user and role
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
