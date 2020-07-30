/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author KSC
 * @description This class is an entity of User
 */
@ApiModel(value = "user info object", description = "user info object")
public class UserInfo {

    /**
     * user id
     */
    @ApiModelProperty(value = "user id")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public UserInfo() {
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserInfo(Long userId,
                    @NotNull @Length(min = 4, max = 20, message = "length.not.valid")
                    @Pattern(regexp = "^[0-9a-zA-Z]+$",
                            message = "Only numeric and alphabetic can be entered") String username,
                    @NotNull @Length(min = 6, max = 20, message = "length.not.valid")
                    @Pattern(regexp = "^[0-9a-zA-Z]+$",
                            message = "Only numeric and alphabetic can be entered") String password
    ) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
