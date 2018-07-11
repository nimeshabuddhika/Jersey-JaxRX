package com.jersey.app.ws.services.impl;


import com.jersey.app.ws.dto.UserDTO;
import com.jersey.app.ws.services.UserService;
import com.jersey.app.ws.utils.UserUtils;
import org.springframework.beans.BeanUtils;

public class UserServiceImpl implements UserService {

    UserUtils userUtils = new UserUtils();

    @Override
    public UserDTO createUser(UserDTO user) {
        UserDTO result = new UserDTO();

        //Validate required fields
        userUtils.validateRequiredFields(user);

        //Check if user is exists

        //Create an entity object

        //Generate secure public user id

        //Generate salt

        //Generate secure password

        //Record data in database

        //Return user


        BeanUtils.copyProperties(user,result);
        return result;
    }
}
