/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.common;

/**
 * @author KSC
 * @description There are some http status in this class.
 */
public class HttpStatus
{
    /**
     * operate successfully
     */
    public static final int SUCCESS = 200;

    /**
     * create object successfully
     */
    public static final int CREATED = 201;

    /**
     * request was accepted
     */
    public static final int ACCEPTED = 202;

    /**
     * operate successfully with no content
     */
    public static final int NO_CONTENT = 204;

    /**
     * resource was removed
     */
    public static final int MOVED_PERM = 301;

    /**
     * redirect
     */
    public static final int SEE_OTHER = 303;

    /**
     * resource was not modified
     */
    public static final int NOT_MODIFIED = 304;

    /**
     * parameter list is incorrect（absence，format is not matched）
     */
    public static final int BAD_REQUEST = 400;

    /**
     * unauthorized
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * Restricted access, authorization expired
     */
    public static final int FORBIDDEN = 403;

    /**
     * Resource, service not found
     */
    public static final int NOT_FOUND = 404;

    /**
     * HTTP method not allowed
     */
    public static final int BAD_METHOD = 405;

    /**
     * Resource conflict, or the resource is locked
     */
    public static final int CONFLICT = 409;

    /**
     * Unsupported data, media type
     */
    public static final int UNSUPPORTED_TYPE = 415;

    /**
     * System internal error
     */
    public static final int ERROR = 500;

    /**
     * Interface not implemented
     */
    public static final int NOT_IMPLEMENTED = 501;
}
