package com.concise.query.module.user;

import com.concise.query.jpa2.AbstractJpa2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService extends AbstractJpa2Service<UserEntity, Integer, UserQuery> {

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
