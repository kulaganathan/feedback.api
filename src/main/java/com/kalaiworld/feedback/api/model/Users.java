package com.kalaiworld.feedback.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
@Data
public class Users {
    @Id
    private String id;
    @Column
    private String userId;
    @Column
    private String password;
}
