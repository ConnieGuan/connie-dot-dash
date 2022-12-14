package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.example.demo")
public class ExceptionHandler {

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> DemoException(DemoException ex) {

        // NOTE: in general I would probably create a more robust error object, but for now we just return a string
        // with a retry message.
        return ResponseEntity.internalServerError().body("Internal server error. Please retry.");

    }


}
