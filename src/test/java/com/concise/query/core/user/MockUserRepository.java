package com.concise.query.core.user;

import com.concise.query.jpa2.AbstractMockRepository;
import com.concise.query.module.user.UserEntity;
import com.concise.query.module.user.UserQuery;
import com.concise.query.module.user.UserRepository;
import org.apache.commons.lang3.StringUtils;

public class MockUserRepository extends AbstractMockRepository<UserEntity, Integer, UserQuery> implements UserRepository {
    public MockUserRepository() {
        super(UserEntity.TABLE);
    }

    @Override
    protected boolean unsatisfied(UserEntity entity, String fieldName, Object v1) {
        if (fieldName.equals("account")) {
            String account = v1.toString();
            if (!StringUtils.equals(entity.getUsername(), account) &&
                    !StringUtils.equals(entity.getEmail(), account) &&
                    !StringUtils.equals(entity.getMobile(), account)
            ) {
                return true;
            }
        }
        return super.unsatisfied(entity, fieldName, v1);
    }
}
