package com.concise.query.module.user;

public interface UserApi {
    UserResponse auth(String loginRequest, String password);
}

