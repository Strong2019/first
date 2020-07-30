/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common.exception.user;

/**
 * @author KSC
 * @description user does exists exception
 */
public class UserDoesExistsException extends UserException {
    /**
     * construction method
     */
    public UserDoesExistsException() {
        super("user.does.exists", null);
    }
}
