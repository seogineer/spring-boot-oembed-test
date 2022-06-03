package com.seogineer.springbootoembedtest.common.advice;

import com.seogineer.springbootoembedtest.common.exception.BadUriException;
import com.seogineer.springbootoembedtest.common.exception.NotSupportedUriException;
import com.seogineer.springbootoembedtest.common.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {BadUriException.class})
    public ResponseEntity<ErrorResponse> handleBadUriException(BadUriException ex) {
        return ResponseEntity.internalServerError().body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

    @ExceptionHandler(value = {NotSupportedUriException.class})
    public ResponseEntity<ErrorResponse> handleBadUriException(NotSupportedUriException ex) {
        return ResponseEntity.internalServerError().body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }
}
