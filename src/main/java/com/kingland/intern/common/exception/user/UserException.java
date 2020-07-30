/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common.exception.user;

import com.kingland.intern.common.exception.BaseException;

/**
 * @author KSC
 * @description user info exception
 */
public class UserException extends BaseException {
    /**
     * construction method
     *
     * @param code error code
     * @param args args
     */
    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
