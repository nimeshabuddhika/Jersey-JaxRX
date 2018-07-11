package com.jersey.app.ws.exceptions;

/**
 *
 * @author Nimesha Buddhika
 */
public class MissingRequiredFieldException extends RuntimeException{

    private static final long serialVersionUID = 9043963887337644642L;

    public MissingRequiredFieldException(String message){
        super(message);
    }

}
