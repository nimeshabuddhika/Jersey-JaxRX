/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jersey.app.ws.ui.routes;

import com.jersey.app.ws.dto.UserDTO;
import com.jersey.app.ws.services.UserService;
import com.jersey.app.ws.services.impl.UserServiceImpl;
import com.jersey.app.ws.ui.model.UserModel;
import com.jersey.app.ws.ui.model.response.UserModelRes;
import org.springframework.beans.BeanUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Nimesha Buddhika
 */
@Path("/users")
public class UserRoute {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UserModelRes createUser(UserModel reqModel){
        UserModelRes resUser = new UserModelRes();

        //Prepare DTO
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(reqModel, userDTO);

        //CreateUser
        UserService userService = new UserServiceImpl();
        UserDTO createdUser = userService.createUser(userDTO);

        //Prepare response
        BeanUtils.copyProperties(createdUser, resUser);

        return resUser;
    }
    
}
