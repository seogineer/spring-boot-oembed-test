package com.seogineer.springbootoembedtest.common.exception;

public class BadUriException extends RuntimeException {
    private static String message = "uri is bad request";

    public BadUriException(){
        super(message);
    }
}
