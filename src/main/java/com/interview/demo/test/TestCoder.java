package com.interview.demo.test;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TestCoder {
    @Test
    void testCode() throws UnsupportedEncodingException {
        System.out.println(URLDecoder.decode("%40", "utf-8"));
    }
}
