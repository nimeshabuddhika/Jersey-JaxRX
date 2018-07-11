package com.jersey.app.ws.services.impl;


import com.jersey.app.ws.dao.DAO;
import com.jersey.app.ws.dao.impl.MySQLDAO;
import com.jersey.app.ws.dto.UserDTO;
import com.jersey.app.ws.services.UserService;
import com.jersey.app.ws.utils.UserUtils;
import org.springframework.beans.BeanUtils;

public class UserServiceImpl implements UserService {

    DAO database;

    public UserServiceImpl(){
        this.database = new MySQLDAO();
    }

    UserUtils userUtils = new UserUtils();

    @Override
    public UserDTO createUser(UserDTO user) {
        UserDTO result = new UserDTO();

        //Validate required fields
        userUtils.validateRequiredFields(user);

        //Check if user is exists
        UserDTO existingUser = this.getUserByUserName(user.getEmail());
        if(existingUser != null){
//            throw UserServiceEx
        }

        //Create an entity object

        //Generate secure public user id

        //Generate salt

        //Generate secure password

        //Record data in database

        //Return user


        BeanUtils.copyProperties(user,result);
        return result;
    }

    private UserDTO getUserByUserName(String userName){
        UserDTO user  = null;
        if(!userName.isEmpty() && userName != null){
            try{
                this.database.openConnection();
                user = this.database.getUserByName(userName);
            }finally {
                this.database.closeConnection();
            }
        }
        return user;
    }
}
