/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.controller;

import com.kingland.intern.domain.UserInfo;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @author KSC
 * @description restful style url
 */
public interface UserInfoController {

    /**
     * register function
     *
     * @param userInfo user info
     * @param request  http servlet request
     * @return ajax result
     */
    public ResponseEntity register(UserInfo userInfo, HttpServletRequest request);
}
