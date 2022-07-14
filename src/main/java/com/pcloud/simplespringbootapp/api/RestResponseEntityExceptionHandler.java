package com.pcloud.simplespringbootapp.api;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RequestNotPermitted.class })
    protected ResponseEntity<Object> handleRateLimiter(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Too many requests";
        return handleExceptionInternal(ex, bodyOfResponse,
            new HttpHeaders(), HttpStatus.TOO_MANY_REQUESTS, request);
    }
}