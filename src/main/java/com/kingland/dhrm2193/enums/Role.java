package com.kingland.dhrm2193.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Role enum
 *
 * @author Rooney
 * @date 2020.07.23
 */

@AllArgsConstructor
@Getter
public enum Role {
    /**
     * ADMIN permission
     */
    ADMIN("ADMIN"),

    /**
     * COMMON permission
     */
    COMMON("COMMON");

    /**
     * user role
     */
    private final String role;
}
