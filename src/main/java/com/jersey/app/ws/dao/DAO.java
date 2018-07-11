package com.jersey.app.ws.dao;

import com.jersey.app.ws.dto.UserDTO;

/**
 * @author Nimesha Buddhika on 7/11/2018
 */
public interface DAO {
    void openConnection();
    UserDTO getUserByName(String userName);
    void closeConnection();

}
