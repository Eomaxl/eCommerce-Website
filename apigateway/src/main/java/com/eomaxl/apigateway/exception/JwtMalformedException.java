package com.eomaxl.apigateway.exception;

import org.springframework.security.core.AuthenticationException;

public class JwtMalformedException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public JwtMalformedException(String msg) {
        super(msg);
    }
}
