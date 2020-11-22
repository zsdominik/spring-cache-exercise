package com.zsirosd.springcacheexercise.util;

public class StringUtil {

    public static String reverseString(String input) {
        StringBuilder sbr = new StringBuilder(input);
        sbr.reverse();
        return sbr.toString();
    }
}
