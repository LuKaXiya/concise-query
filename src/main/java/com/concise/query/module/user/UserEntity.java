package com.concise.query.module.user;

import com.concise.query.entity.IntegerId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = UserEntity.TABLE)
//@EqualsAndHashCode(callSuper = true)
public class UserEntity extends IntegerId {

    public static final String TABLE = "user";

    private String username;
    private String password;
    private String mobile;
    private String email;
    private String nickname;
    private boolean valid;
}