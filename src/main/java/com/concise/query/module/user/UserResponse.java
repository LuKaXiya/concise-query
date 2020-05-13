package com.concise.query.module.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class UserResponse {
    private Integer id;
    private String username;
    private String mobile;
    private String email;
    private String nickname;
    private Boolean valid;

    public static UserResponse of(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userEntity, userResponse);
        return userResponse;
    }
}
