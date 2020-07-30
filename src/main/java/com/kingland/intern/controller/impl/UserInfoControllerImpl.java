/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.controller.impl;

import com.kingland.intern.common.response.BaseResponseEntity;
import com.kingland.intern.controller.UserInfoController;
import com.kingland.intern.domain.UserInfo;
import com.kingland.intern.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author KSC
 * @description restful style url
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "userController", description = "register, loadUserByName")
public class UserInfoControllerImpl implements UserInfoController {
    /**
     * user Service
     */
    private UserInfoService userInfoService;

    /**
     * Injection by construction method
     *
     * @param userInfoService user Service
     */
    public UserInfoControllerImpl(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * register function
     *
     * @param userInfo user info
     * @return ajax result
     */
    @SuppressWarnings("rawtypes")
    @Override
    @PostMapping("/register")
    @ApiOperation(value = "register", notes = "user register")
    public ResponseEntity register(@RequestBody @Valid UserInfo userInfo, HttpServletRequest request) {
        // Call the register method of user service
        userInfoService.register(userInfo);
        // create a base response entity with HttpStatus 200 Ok
        BaseResponseEntity baseResponseEntity = new BaseResponseEntity(HttpStatus.OK, "operate.success");
        // set path where response entity was created
        baseResponseEntity.setPath(request.getServletPath());
        return new ResponseEntity<>(baseResponseEntity, HttpStatus.OK);
    }
}
