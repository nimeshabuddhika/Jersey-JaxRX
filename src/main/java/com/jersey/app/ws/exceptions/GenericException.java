package com.jersey.app.ws.exceptions;

import com.jersey.app.ws.ui.model.response.errors.ErrorMessage;
import com.jersey.app.ws.ui.model.response.errors.ErrorMessages;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Nimesha Buddhika on 7/11/2018
 */
@Provider
public class GenericException implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessage(throwable.getMessage(), ErrorMessages.INTERNAL_SERVER_ERROR.name(), "http://myapp.com/docs")).build();
    }
}
