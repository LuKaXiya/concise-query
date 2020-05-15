package com.concise.query.module.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Getter
@Setter
public class UserResponse implements Serializable {
    private static final long serialVersionUID = -1L;
    private Integer id;
    private String username;
    private String mobile;
    private String email;
    private String nickname;
    @JsonIgnore
    private String password;
    private Boolean valid;

    public static UserResponse of(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userEntity, userResponse);
        return userResponse;
    }
}
