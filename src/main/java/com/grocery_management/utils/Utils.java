package com.grocery_management.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utils {

    private Utils() {
    }

    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus status) {
        return new ResponseEntity<String>("{\"message\":\"" + message + "\"}", status);
    }
}
