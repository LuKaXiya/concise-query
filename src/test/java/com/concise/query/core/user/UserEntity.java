package com.concise.query.core.user;

import com.concise.query.entity.IntegerId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;


@Getter
@Setter
//@Entity
@Table(name = UserEntity.TABLE)
public class UserEntity extends IntegerId {
    public static final String TABLE = "user";

    private String username;
    private String password;
    private String mobile;
    private String email;
    private String nickname;
    private String valid;
}