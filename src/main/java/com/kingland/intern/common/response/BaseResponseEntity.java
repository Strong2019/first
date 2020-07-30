/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common.response;

import com.kingland.intern.utils.Utils;

import java.util.Date;

/**
 * @author KSC
 * @description base response entity
 */
public class BaseResponseEntity {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * HttpStatus
     */
    private int status;

    /**
     * error msg
     */
    private String message;

    /**
     * the time when response entity was created
     */
    private String timestamp = new Date().toString();

    /**
     * the path where response entity was created
     */
    private String path;

    /**
     * data
     */
    private Object data;

    /**
     * construction method
     *
     * @param status  http status
     * @param message error message
     */
    public BaseResponseEntity(int status, String message) {
        this.status = status;
        // get message by i18n
        this.message = Utils.getMessage(message, null);
    }
}
