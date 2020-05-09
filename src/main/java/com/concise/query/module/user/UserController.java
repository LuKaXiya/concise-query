package com.concise.query.module.user;

import com.concise.query.core.PageList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("query")
    public List<UserEntity> query(UserQuery userQuery) {
        return userService.query(userQuery);
    }

    @GetMapping("page")
    public PageList<UserEntity> page(UserQuery userQuery) {
        return userService.page(userQuery);
    }

    @GetMapping("get")
    public UserEntity get(Integer id) {
        return userService.get(id);
    }
}
