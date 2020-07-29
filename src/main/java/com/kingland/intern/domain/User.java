/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.domain;

import com.sun.istack.internal.NotNull;
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
public class User {

    /**
     * user id
     */
    private int id;

    /**
     * user name
     */
    @NotNull
    @Length(min = 4, max = 20, message = "length.not.valid")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Only numeric and alphabetic can be entered")
    private String username;

    /**
     * password
     */
    @NotNull
    @Length(min = 6, max = 20, message = "length.not.valid")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Only numeric and alphabetic can be entered")
    private String password;

    /**
     * role
     */
    @Length(max = 32, message = "length.less.valid")
    private String role;

    /**
     * description
     */
    @Length(max = 128, message = "length.less.valid")
    private String description;
}
