package com.concise.query.module.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    protected Integer id;

    private String username;
    private String password;
    private String mobile;
    private String email;
    private String nickname;
    private String valid;
}