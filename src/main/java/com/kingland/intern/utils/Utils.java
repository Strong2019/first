/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.utils;

import com.kingland.intern.common.exception.user.UserPasswordNotMatchException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author KSC
 * @description There are some utils methods in this class.
 */
public class Utils {
    /**
     * Judge whether the string is empty. If it is empty, throw an error message
     *
     * @param string string
     * @param msg    error message
     * @throws UsernameNotFoundException username not found exception
     */
    public static void isNull(String string, String msg) throws UsernameNotFoundException {
        if (null == string || "".equals(string.trim())) {
            throw new UsernameNotFoundException(msg);
        }
    }

    /**
     * Judge whether the object is empty. If it is empty, throw an error message
     *
     * @param obj object
     * @throws UsernameNotFoundException username not found exception
     */
    public static void isNull(Object obj) throws UsernameNotFoundException {
        if (null == obj) {
            throw new UserPasswordNotMatchException();
        }
    }


    public static boolean isNotNull(Object object) {
        return object != null;
    }

    /**
     * Check if String is not empty
     *
     * @param str         string
     * @param ignoreSpace whether ignore space
     * @return boolean
     */
    public static boolean isStringEmpty(String str, boolean ignoreSpace) {
        if (str == null) {
            return true;
        }
        if (ignoreSpace) {
            str = str.trim();
        }
        if ("".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * get message by i18n
     *
     * @param code code
     * @param args args
     * @return i18n string
     */
    public static String getMessage(String code, Object[] args) {
        String message = null;
        if (!Utils.isStringEmpty(code, true)) {
            message = MessageUtils.message(code, args);
        }
        if (message == null) {
            message = "";
        }
        return message;
    }
}
