package com.jersey.app.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Nimesha Buddhika on 7/11/2018
 */
@Entity(name = "User")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 4521858930730026575L;

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String salt;
    private String encPassword;
    private String userId;

}
