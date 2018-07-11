package com.jersey.app.ws.ui.entrypoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Nimesha Buddhika on 7/11/2018
 */
@Path("/test")
public class TestRoute {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testApi(){
        return "Received";
    }

}
