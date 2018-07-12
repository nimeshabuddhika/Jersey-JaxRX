package com.jersey.app.ws.exceptions.errors;

/**
 * @author Nimesha Buddhika on 7/12/2018
 */
public class JerseyExceptionMapper extends RuntimeException{
    private static final long serialVersionUID = 7937489330480371671L;

    public JerseyExceptionMapper(String message){
        super(message);
    }
}
