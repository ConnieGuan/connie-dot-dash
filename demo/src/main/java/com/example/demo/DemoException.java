package com.example.demo;

public class DemoException extends RuntimeException {

    // NOTE: could potentially create a new exception class here to be thrown when an issue occurs
    // within the server. This is just a basic example of what a potential exception class might include
    private String errorCode;
    private String errorMsg;
    private String httpStatus;
}
