package com.jersey.app.ws.utils;

import com.jersey.app.ws.dto.UserDTO;
import com.jersey.app.ws.exceptions.MissingRequiredFieldException;
import com.jersey.app.ws.exceptions.errors.ErrorMessages;


public class UserUtils {
    public void validateRequiredFields(UserDTO userDto) throws MissingRequiredFieldException {
        if (userDto.getFirstName() == null
                || userDto.getFirstName().isEmpty()
                || userDto.getLastName() == null
                || userDto.getLastName().isEmpty()
                || userDto.getEmail() == null
                || userDto.getEmail().isEmpty()
                || userDto.getPassword() == null
                || userDto.getPassword().isEmpty()) {
            throw new MissingRequiredFieldException(
                    ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }
    }
}
