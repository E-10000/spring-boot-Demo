package com.qiang.springbootweb01.exception;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(){
        super("用户名不存在");
    }
}
