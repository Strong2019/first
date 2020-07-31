/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.utils;

import com.kingland.intern.common.Common;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Base64;

/**
 * @author KSC
 * @description It is my password encoder
 */
public class MyPasswordEncoder implements PasswordEncoder {
    /**
     * prefix
     */
    public static final String PREFIX = "{";

    /**
     * suffix
     */
    public static final String SUFFIX = "}";

    /**
     * encode hash as base64
     */
    private boolean encodeHashAsBase64;

    /**
     * salt
     */
    private String salt;

    /**
     * digester
     */
    private MyDigester digester;

    /**
     * Use SHA-1 by default
     *
     * @param salt salt
     */
    public MyPasswordEncoder(String salt) {
        this.salt = salt;
        this.digester = new MyDigester(Common.SHA_1, 1);
    }

    /**
     * Encodes the rawPass using a MessageDigest. If a salt is specified it will be merged
     * with the password before encoding.
     *
     * @param rawPassword The plain text password
     * @return Hex string of password digest (or base64 encoded string if
     * encodeHashAsBase64 is enabled. {salt} is added as the prefix.
     */
    @Override
    public String encode(CharSequence rawPassword) {
        String salt = PREFIX + this.salt + SUFFIX;
        return digest(salt, rawPassword);
    }

    /**
     * To encode a raw password with returning the pure password only, without salt being
     * added on top as the prefix
     *
     * @param rawPassword raw password
     * @return
     */
    public String encodePurePassword(CharSequence rawPassword) {
        String salt = PREFIX + this.salt + SUFFIX;
        return digestPurePassword(salt, rawPassword);
    }

    /**
     * @param salt        salt
     * @param rawPassword raw password
     * @return
     */
    private String digest(String salt, CharSequence rawPassword) {
        String saltedPassword = rawPassword + salt;

        byte[] digest = this.digester.digest(Utf8.encode(saltedPassword));
        String encoded = encode(digest);
        return salt + encoded;
    }

    private String digestPurePassword(String salt, CharSequence rawPassword) {
        String saltedPassword = rawPassword + salt;

        byte[] digest = this.digester.digest(Utf8.encode(saltedPassword));
        return encode(digest);
    }

    private String encode(byte[] digest) {
        if (this.encodeHashAsBase64) {
            return Utf8.decode(Base64.getEncoder().encode(digest));
        } else {
            return new String(Hex.encode(digest));
        }
    }

    /**
     * Takes a previously encoded password and compares it with a raw password after mixing
     * in the salt and encoding that value
     *
     * @param rawPassword     plain text password
     * @param encodedPassword previously encoded password
     * @return true or false
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String encodePassword = "";
        // if raw password is not null
        if (!Utils.isStringEmpty(String.valueOf(rawPassword), true)) {
            //create password encoder
            encodePassword = this.encodePurePassword(String.valueOf(rawPassword));
        }
        return PasswordEncoderUtils.equals(encodedPassword, encodePassword);
    }
}
