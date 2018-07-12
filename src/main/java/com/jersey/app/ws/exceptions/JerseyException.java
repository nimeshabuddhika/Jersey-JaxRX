package com.jersey.app.ws.exceptions;

/**
 * @author Nimesha Buddhika on 7/12/2018
 */
public class JerseyException extends RuntimeException{

    private static final long serialVersionUID = 5698912669933828607L;

    public JerseyException(String message) {
        super(message);
    }
}
