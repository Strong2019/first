/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingland.intern.common.response.BaseResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author KSC
 * @description response to login fail
 */
@Component
public class FailureHandler implements AuthenticationFailureHandler {

    /**
     * response to login fail
     *
     * @param request   http servlet request
     * @param response  http servlet response
     * @param exception authentication exception
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        // set content type
        response.setContentType("application/json;charset=utf-8");
        // create a object instanceof user info response entity
        BaseResponseEntity baseResponseEntity = new BaseResponseEntity(HttpStatus.UNAUTHORIZED.value(), "user.password.not.match");
        // set path where response
        baseResponseEntity.setPath(request.getServletPath());
        // response to the request
        response.getWriter().append(new ObjectMapper().writeValueAsString(new ResponseEntity<>(baseResponseEntity, HttpStatus.UNAUTHORIZED)));
    }
}
