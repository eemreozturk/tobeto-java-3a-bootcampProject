package com.example.bootcampProject.core.exceptions.types;

import java.io.Serial;

public class BusinessException extends RuntimeException{

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1630027230917116204L;
    public BusinessException(String message) {
        super(message);
    }

}
