package com.regular;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/8/26 11:22
 */
class TestChar {
    @Test
    void encoding() throws UnsupportedEncodingException {
        String 共 = "共";
        System.out.println(new String(共.getBytes("utf-8")));
    }
}
