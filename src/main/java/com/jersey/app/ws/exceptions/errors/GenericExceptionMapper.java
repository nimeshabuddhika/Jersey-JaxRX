package com.jersey.app.ws.exceptions.errors;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Nimesha Buddhika on 7/11/2018
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessageModel(exception.getMessage(),exception.getStackTrace()[0].getClassName(), exception.getStackTrace()[0].getLineNumber())).build();
    }
}
