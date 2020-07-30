/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.controller.impl;

import com.kingland.intern.common.exception.BaseException;
import com.kingland.intern.controller.UserInfoController;
import com.kingland.intern.domain.UserInfo;
import com.kingland.intern.service.UserInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

@SpringBootTest
class UserInfoControllerImplTest {
    /**
     * userInfoController bean
     */
    @Autowired
    private UserInfoController controller;

    @MockBean
    private UserInfoService service;

    @MockBean
    private HttpServletRequest request;

    @MockBean
    private UserInfo user;

    @Test
    void register() {
        Object obj = null;
        try {
            obj = controller.register(user, request);
        } catch (BaseException e) {

        }
        Assertions.assertTrue(obj != null);
        Assertions.assertTrue(obj instanceof ResponseEntity);
    }
}