package com.jersey.app.ws.exceptions;

/**
 * @author Nimesha Buddhika on 7/11/2018
 */
public class CouldNotCreateException extends RuntimeException{

    private static final long serialVersionUID = 7937489330480371671L;

    public CouldNotCreateException(String message){
        super(message);
    }

}
