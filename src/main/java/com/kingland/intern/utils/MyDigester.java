/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author KSC
 * @description Helper for working with the MessageDigest API.
 * Performs the configured number of iterations of the hashing algorithm per digest to aid in protecting against brute force attacks.
 */
public class MyDigester {

    /**
     * algorithm: which algorithm encoding use
     */
    private final String algorithm;

    /**
     * iterations: the number of times encoding is required
     */
    private int iterations;

    /**
     * Create a new Digester.
     *
     * @param algorithm  the digest algorithm; for example, "SHA-1" or "SHA-256".
     * @param iterations the number of times to apply the digest algorithm to the input
     */
    public MyDigester(String algorithm, int iterations) {
        // eagerly validate the algorithm
        createDigest(algorithm);
        this.algorithm = algorithm;
        setIterations(iterations);
    }

    /**
     * execute the digest
     *
     * @param value value array
     * @return byte array
     */
    public byte[] digest(byte[] value) {
        MessageDigest messageDigest = createDigest(algorithm);
        for (int i = 0; i < iterations; i++) {
            value = messageDigest.digest(value);
        }
        return value;
    }

    /**
     * set iterations
     *
     * @param iterations iterations
     */
    final void setIterations(int iterations) {
        if (iterations <= 0) {
            throw new IllegalArgumentException("Iterations value must be greater than zero");
        }
        this.iterations = iterations;
    }

    /**
     * create digest with algorithm
     *
     * @param algorithm algorithm
     * @return MessageDigest
     */
    private static MessageDigest createDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No such hashing algorithm", e);
        }
    }
}