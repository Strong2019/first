/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.utils;

import org.springframework.context.MessageSource;

/**
 * @author KSC
 * @description get i18n resources file
 */
public class MessageUtils {
    /**
     * get message by key-rgs and entrust it to spring messageSource
     *
     * @param code msg key
     * @param args args
     * @return get i18n translate
     */
    public static String message(String code, Object... args) {
        // get bean by spring utils
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        // return the message which obtained through i18n
        return messageSource.getMessage(code, args, null);
    }
}
