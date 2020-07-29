/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.utils;

import com.kingland.intern.common.HttpStatus;

import java.util.HashMap;

/**
 * @author KSC
 * @description return ajax response with http status
 */
public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * code
     */
    public static final String CODE_TAG = "code";

    /**
     * msg content
     */
    public static final String MSG_TAG = "msg";

    /**
     * data obj
     */
    public static final String DATA_TAG = "data";

    /**
     * empty ajax result
     */
    public AjaxResult() {
    }

    /**
     * init a AjaxResult obj
     *
     * @param code code
     * @param msg  response content
     */
    public AjaxResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * init a AjaxResult obj
     *
     * @param code code
     * @param msg  response content
     * @param data data obj
     */
    public AjaxResult(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (Utils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * return success msg
     * @return success msg
     */
    public static AjaxResult success() {
        return AjaxResult.success("operate.success");
    }

    /**
     * return success msg
     *
     * @param msg msg content
     * @return success msg
     */
    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg, null);
    }

    /**
     * return success msg
     *
     * @param msg  msg content
     * @param data data obj
     * @return success msg
     */
    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * return success data
     *
     * @return success msg
     */
    public static AjaxResult success(Object data) {
        return AjaxResult.success("operate.success", data);
    }


    /**
     * return error msg
     *
     * @return error msg
     */
    public static AjaxResult error() {
        return AjaxResult.error("operate.failed");
    }

    /**
     * return error msg
     *
     * @param msg msg content
     * @return warn msg
     */
    public static AjaxResult error(String msg) {
        return AjaxResult.error(msg, null);
    }

    /**
     * return error msg
     *
     * @param msg  msg content
     * @param data data obj
     * @return warn msg
     */
    public static AjaxResult error(String msg, Object data) {
        return new AjaxResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * return error msg
     *
     * @param code code
     * @param msg  msg content
     * @return warn msg
     */
    public static AjaxResult error(int code, String msg) {
        return new AjaxResult(code, msg, null);
    }
}