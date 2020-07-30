/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author KSC
 * @description There are some enums in this file.
 */

@AllArgsConstructor
@Getter
public enum Role {
    /**
     * ADMIN permission
     * can visit all page
     */
    ADMIN((long) 1, "ADMIN"),

    /**
     * COMMON permission
     * cannot visit admin page
     */
    COMMON((long) 2, "COMMON");

    /**
     * role id
     */
    private final Long id;

    /**
     * user role
     */
    private final String role;
}
