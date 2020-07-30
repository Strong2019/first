/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.enums;

/**
 * @author KSC
 * @description There are some enums in this file.
 */
public enum Role {
    /**
     * ADMIN permission
     * can visit all page
     */
    ADMIN(1L, "ADMIN"),
    /**
     * COMMON permission
     * cannot visit admin page
     */
    COMMON(2L, "COMMON");

    Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    /**
     * role id
     */
    private final Long id;

    /**
     * user role
     */
    private final String role;
}
