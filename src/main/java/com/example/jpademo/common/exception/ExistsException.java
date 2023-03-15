package com.example.jpademo.common.exception;

import org.springframework.context.MessageSource;


public class ExistsException extends IllegalArgumentException {

    public ExistsException(String s) {
        super(s);
    }
}
