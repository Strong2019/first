/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.service.impl;

import com.kingland.intern.common.exception.BaseException;
import com.kingland.intern.domain.UserInfo;
import com.kingland.intern.service.UserInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserInfoServiceImplTest {
    @MockBean
    private UserInfoService service;

    @MockBean
    private UserInfo user;

    @Test
    void register() {
        Boolean obj = null;
        try {
            when(service.register(user)).thenReturn(true);
            obj = service.register(user);
        } catch (BaseException e) {

        }
        Assertions.assertTrue(obj);
    }
}