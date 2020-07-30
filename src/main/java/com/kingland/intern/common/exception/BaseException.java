/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common.exception;

import com.kingland.intern.utils.Utils;

/**
 * @author KSC
 * @description base exception
 */
public class BaseException extends RuntimeException {
    /**
     * in which module
     */
    private String module;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    /**
     * error code
     */
    private String code;

    /**
     * error code with some args
     */
    private Object[] args;

    /**
     * error msg
     */
    private String defaultMessage;

    /**
     * construction method
     *
     * @param module         Which module is the exception generated in
     * @param code           error code
     * @param args           args
     * @param defaultMessage default message
     */
    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    /**
     * to get i18n message by code
     *
     * @return message string
     */
    @Override
    public String getMessage() {
        return Utils.getMessage(code, args);
    }
}
