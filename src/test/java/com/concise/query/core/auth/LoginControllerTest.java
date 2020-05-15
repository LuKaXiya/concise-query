package com.concise.query.core.auth;

import com.concise.query.core.user.UserControllerTest;
import com.concise.query.module.auth.LoginController;
import com.concise.query.module.auth.LoginRequest;
import com.concise.query.module.user.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
public class LoginControllerTest {

    LoginController loginController = new LoginController();
    HttpServletRequest httpRequest;

    @BeforeEach
    void setUp() {
        httpRequest = new MockHttpServletRequest();
        loginController.userApi = UserControllerTest.userController;
    }

    @Test
    void login() {
        LoginController loginController = new LoginController();
        loginController.userApi = UserControllerTest.userController;
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAccount("f0rb");
        loginRequest.setPassword("123456");
        try {
            loginController.login(loginRequest, httpRequest);
        } catch (Exception e) {
            fail("Login failed", e);
        }

        UserResponse userResponse = loginController.account(httpRequest);
        assertEquals("自在", userResponse.getNickname());

    }

    @Test
    void notLogin() {
        try {
            loginController.account(httpRequest);
        } catch (Exception e) {
            assertEquals("会话过期", e.getMessage());
        }
    }

    @Test
    void loginWithWrongAccount() {
        LoginController loginController = new LoginController();
        loginController.userApi = UserControllerTest.userController;
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAccount("none");
        loginRequest.setPassword("123456");
        try {
            loginController.login(loginRequest, httpRequest);
            fail("Login with wrong account should fail");
        } catch (Exception e) {
            assertEquals("账号不存在", e.getMessage());
        }
    }

    @Test
    void loginWithWrongPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAccount("f0rb@163.com");
        loginRequest.setPassword("12345678");
        try {
            loginController.login(loginRequest, httpRequest);
            fail("Login with wrong password should fail");
        } catch (Exception e) {
            assertEquals("密码错误", e.getMessage());
        }
    }

    @Test
    void loginWithWrongInvalid() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAccount("17778888881");
        loginRequest.setPassword("123456");
        try {
            loginController.login(loginRequest, httpRequest);
            fail("Login with wrong password should fail");
        } catch (Exception e) {
            assertEquals("账号被禁用", e.getMessage());
        }
    }
}
