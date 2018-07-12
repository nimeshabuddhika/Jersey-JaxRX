package com.jersey.app.ws.exceptions.errors;

import com.jersey.app.ws.exceptions.CouldNotCreateException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author Nimesha Buddhika on 7/12/2018
 */
public class CouldNotCreateExceptionMapper implements ExceptionMapper<CouldNotCreateException> {
    @Override
    public Response toResponse(CouldNotCreateException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage(exception.getMessage(), ErrorMessages.RECORD_ALREADY_EXISTS.name(), "http://myapp.com/docs")).build();
    }
}
