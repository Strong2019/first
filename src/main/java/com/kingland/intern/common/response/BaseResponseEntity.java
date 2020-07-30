/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common.response;

import com.kingland.intern.utils.Utils;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @author KSC
 * @description base response entity
 */
@Data
public class BaseResponseEntity {
    /**
     * HttpStatus
     */
    private HttpStatus status;

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
    public BaseResponseEntity(HttpStatus status, String message) {
        this.status = status;
        // get message by i18n
        this.message = Utils.getMessage(message, null);
    }
}
