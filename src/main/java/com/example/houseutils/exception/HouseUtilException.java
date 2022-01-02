package com.example.houseutils.exception;

public class HouseUtilException extends RuntimeException{

    private ErrorCode errorCode;
    private String message;

    public HouseUtilException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMessage());
    }

    public HouseUtilException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode;
        this.message = customMessage;
    }
}
