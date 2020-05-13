package com.concise.query.core.mybatis;

import com.concise.query.core.CrudBuilder;
import com.concise.query.module.user.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrudBuilderTest {

    @Test
    void create() {
        assertEquals("INSERT INTO user (username, password, mobile, email, nickname, valid) VALUES (#{username}, #{password}, #{mobile}, #{email}, #{nickname}, #{valid})",
                new CrudBuilder().create(new UserEntity()));
    }

    @Test
    void update() {
        assertEquals("UPDATE user SET username = #{username}, password = #{password}, mobile = #{mobile}, email = #{email}, nickname = #{nickname}, valid = #{valid} WHERE id = #{id}",
                new CrudBuilder().update(new UserEntity()));
    }
}
