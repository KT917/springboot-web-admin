package com.example.boot05webadmin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED,reason = "用户数量太多")
public class UserToManyException extends RuntimeException{

    public UserToManyException(){}
    public UserToManyException(String message){
        super(message);
    }


}
