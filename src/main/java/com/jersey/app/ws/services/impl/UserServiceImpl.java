package com.jersey.app.ws.services.impl;


import com.jersey.app.ws.dao.DAO;
import com.jersey.app.ws.dao.impl.MySQLDAO;
import com.jersey.app.ws.dto.UserDTO;
import com.jersey.app.ws.exceptions.CouldNotCreateException;
import com.jersey.app.ws.services.UserService;
import com.jersey.app.ws.exceptions.errors.ErrorMessages;
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
            throw new CouldNotCreateException(ErrorMessages.RECORD_ALREADY_EXISTS.name());
        }


        //Generate secure public user id
        String userId = new UserUtils().generatedUUID();
        user.setUserId(userId);

        //Generate salt
        String salt = userUtils.getSalt(30);

        //Generate secure password
        String encPassword = userUtils.generateSecurePassword(userId,salt);
        user.setSalt(salt);
        user.setEncPassword(encPassword);

        //Create an entity object
        this.saveUser(user);


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

    private UserDTO saveUser(UserDTO user) {
        UserDTO returnValue = null;
        // Connect to database
        try {
            this.database.openConnection();
            returnValue = this.database.saveUser(user);
        } finally {
            this.database.closeConnection();
        }

        return returnValue;
    }
}
