/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common.exception;

import com.kingland.intern.common.response.BaseResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * @author KSC
 * @description
 */
@RestControllerAdvice
class GlobalExceptionHandler {

    /**
     * logger
     */
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Annotation validation error for entity class, response when it occur
     *
     * @param e exception
     * @return response entity
     */
    @ExceptionHandler(value = BindException.class)
    public ResponseEntity modelFieldEmptyException(BindException e) {
        log.error(e.getMessage(), e);
        Map<String, Object> errors = e.getBindingResult().getFieldErrors().stream().collect(toMap(FieldError::getField, FieldError::getCode));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * response when defined exception occur
     *
     * @param e exception
     * @return response entity
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity modelFieldEmptyException(Exception e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        // create a base response entity with HttpStatus 500
        BaseResponseEntity baseResponseEntity = new BaseResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "operate.failed");
        // set path where response entity was created
        baseResponseEntity.setPath(request.getServletPath());
        return new ResponseEntity<>(baseResponseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}