package com.concise.query.module.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginRequest {
    @NotNull
    private String account;

    @NotNull
    private String password;
}
