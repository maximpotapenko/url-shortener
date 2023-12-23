package com.example.linkshortener.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomStringGenerator implements StringGenerator {
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    private static final SecureRandom rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String generate(int length) {
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int val = rand.nextInt(CHARS.length() - 1);

            builder.append(CHARS.charAt(val));
        }

        return builder.toString();
    }
}
