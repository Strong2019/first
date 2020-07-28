package com.kingland.dhrm2193.utils;

import com.kingland.dhrm2193.bean.User;
import com.kingland.dhrm2193.enums.Role;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Utils
 *
 * @author Rooney
 * @version 1.0
 * @date 2020/7/27 10:43 AM
 * @description
 */
public class Utils {
    /**
     * Judge whether the string is empty. If it is empty, throw an error message
     *
     * @param string string
     * @param msg error message
     * @throws UsernameNotFoundException username not found exception
     */
    public static void isNull(String string, String msg) throws UsernameNotFoundException {
        if (null == string || "".equals(string)) {
            throw new UsernameNotFoundException(msg);
        }
    }

    /**
     * Judge whether the object is empty. If it is empty, throw an error message
     *
     * @param obj object
     * @param msg error message
     * @throws UsernameNotFoundException username not found exception
     */
    public static void isNull(Object obj, String msg) throws UsernameNotFoundException {
        if (null == obj) {
            throw new UsernameNotFoundException(msg);
        }
    }

    /**
     * set the basic field for user register
     *
     * @param user user
     */
    public static void setUser(User user) {
        // set user permissions
        user.setRole(Role.COMMON.getRole());
        // set user description
        user.setDescribe("Common user, the power of visiting home page");
        // I can also set the created_time, create_user and other basic field information
    }
}
