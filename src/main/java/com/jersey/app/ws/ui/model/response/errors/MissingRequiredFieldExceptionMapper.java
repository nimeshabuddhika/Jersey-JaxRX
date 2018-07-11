package com.jersey.app.ws.ui.model.response.errors;



import com.jersey.app.ws.exceptions.MissingRequiredFieldException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Nimesha Buddhika on 7/11/2018
 */
@Provider
public class MissingRequiredFieldExceptionMapper implements ExceptionMapper<MissingRequiredFieldException> {


    @Override
    public Response toResponse(MissingRequiredFieldException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage(exception.getMessage(),ErrorMessages.MISSING_REQUIRED_FIELD.name(),"http://myapp.com/docs")).build();
    }
}
