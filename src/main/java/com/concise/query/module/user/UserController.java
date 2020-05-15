package com.concise.query.module.user;

import com.concise.query.core.PageList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("query")
    public List<UserResponse> query(UserQuery userQuery) {
        return userService.query(userQuery, UserResponse::of);
    }

    @GetMapping("page")
    public PageList<UserResponse> page(UserQuery userQuery) {
        PageList<UserResponse> page = userService.page(userQuery, UserResponse::of);
        return userService.page(userQuery, UserResponse::of);
    }

    @GetMapping("get")
    public UserResponse get(Integer id) {
        return UserResponse.of(userService.get(id));
    }

    @PostMapping("save")
    public void save(@RequestBody UserRequest userRequest) {
        userService.save(userRequest.toEntity());
    }

    @PostMapping("delete")
    public void delete(int id) {
        userService.delete(id);
    }

}
