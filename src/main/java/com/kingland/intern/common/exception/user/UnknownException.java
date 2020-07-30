/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common.exception.user;

/**
 * @author KSC
 * @description unknown exception
 */
public class UnknownException extends UserException {
    /**
     * construction method
     */
    public UnknownException() {
        super("user.unknown.error", null);
    }
}
