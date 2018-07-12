package com.jersey.app.ws.utils;

import com.jersey.app.ws.dto.UserDTO;
import com.jersey.app.ws.exceptions.MissingRequiredFieldException;
import com.jersey.app.ws.exceptions.errors.ErrorMessages;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;


public class UserUtils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int ITERATIONS = 10000;
    private final int KEY_LENGTH = 256;

    public String generatedUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }

    public String generateUserId(int length) {
        return generateRandomString(length);
    }

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

    public String getSalt(int length){
        return generateRandomString(length);
    }
    public String generateSecurePassword(String password, String salt) {
        return new String(Base64.encodeBase64(hash(password.toCharArray(), salt.getBytes())));
    }

    public byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (InvalidKeySpecException e) {
            throw new AssertionError(e);
        } finally {
            spec.clearPassword();
        }
    }
}
