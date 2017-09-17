package com.jayway.jsonpath.matchers.helpers;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class ResourceHelpers {
    public static String resource(String resource) {
        try {
            return IOUtils.toString(getSystemResourceAsStream(resource));
        } catch (IOException e) {
            throw new AssertionError("Resource not found: " + e.getMessage());
        }
    }

}
