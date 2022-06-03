package com.seogineer.springbootoembedtest.common.exception;

public class NotSupportedUriException extends RuntimeException {
    private static String message = "This uri is not supported";

    public NotSupportedUriException(){
        super(message);
    }
}
