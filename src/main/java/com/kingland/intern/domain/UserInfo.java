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
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @author KSC
 * @description This class is an entity of User
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "user info object", description = "user info object")
public class UserInfo {

    /**
     * user id
     */
    @ApiModelProperty(value = "user id")
    private Long userId;

    /**
     * user name
     */
    @NotNull
    @ApiModelProperty(value = "user name")
    @Length(min = 4, max = 20, message = "length.not.valid")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Only numeric and alphabetic can be entered")
    private String username;

    /**
     * password
     */
    @NotNull
    @ApiModelProperty(value = "user password")
    @Length(min = 6, max = 20, message = "length.not.valid")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Only numeric and alphabetic can be entered")
    private String password;

}
