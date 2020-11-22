package com.zsirosd.springcacheexercise.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {

    @Test
    void shouldReverseString() {
        String input = "Some String";
        String expected = "gnirtS emoS";

        assertEquals(expected, StringUtil.reverseString(input));
    }

}
