package com.concise.query.core.user;

import com.concise.query.jpa2.AbstractMockRepository;
import com.concise.query.module.user.UserEntity;
import com.concise.query.module.user.UserQuery;
import com.concise.query.module.user.UserRepository;

public class MockUserRepository extends AbstractMockRepository<UserEntity, Integer, UserQuery> implements UserRepository {
    public MockUserRepository() {
        super(UserEntity.TABLE);
    }
}
