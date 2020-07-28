package com.kingland.dhrm2193.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Entity
 *
 * @author Rooney
 * @date 2020.07.23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * user id
     */
    private int id;
    /**
     * user name
     */
    private String username;
    /**
     * password
     */
    private String password;

    /**
     * role
     */
    private String role;

    /**
     * describe
     */
    private String describe;
}
