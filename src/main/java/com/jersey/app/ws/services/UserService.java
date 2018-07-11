package com.jersey.app.ws.services;


import com.jersey.app.ws.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO user);
}
