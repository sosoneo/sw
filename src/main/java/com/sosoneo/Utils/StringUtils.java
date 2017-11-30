package com.sosoneo.Utils;

/**
 * Created by sosoneo on 2017/11/29.
 */
public class StringUtils {
    public static boolean equals(String stringA, String stringB) {
        if (stringA==null || stringB==null) {
            return false;
        }
        return stringA.equals(stringB);
    }
}
