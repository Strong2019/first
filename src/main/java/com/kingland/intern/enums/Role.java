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
    ADMIN("ADMIN"),

    /**
     * COMMON permission
     * cannot visit admin page
     */
    COMMON("COMMON");

    /**
     * user role
     */
    private final String role;
}
