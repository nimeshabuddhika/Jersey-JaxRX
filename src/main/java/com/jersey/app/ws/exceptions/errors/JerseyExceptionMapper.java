package com.jersey.app.ws.exceptions.errors;

import com.jersey.app.ws.exceptions.JerseyException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Nimesha Buddhika on 7/12/2018
 */
@Provider
public class JerseyExceptionMapper implements ExceptionMapper<JerseyException> {
    @Override
    public Response toResponse(JerseyException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessageModel(e.getMessage(),e.getStackTrace()[0].getClassName(), e.getStackTrace()[0].getLineNumber())).build();
    }
}
