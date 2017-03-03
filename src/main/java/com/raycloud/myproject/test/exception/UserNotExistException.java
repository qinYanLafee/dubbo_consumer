package com.raycloud.myproject.test.exception;

/**
 * Created by 001117020012 on 2017/2/23.
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserNotExistException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public UserNotExistException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public UserNotExistException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
