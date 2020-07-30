/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common.exception.user;

/**
 * @author KSC
 * @description user does not exists or user password is incorrect
 */
public class UserPasswordNotMatchException extends UserException {
    /**
     * construction method
     */
    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
