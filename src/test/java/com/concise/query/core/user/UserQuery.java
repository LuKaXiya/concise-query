package com.concise.query.core.user;

import com.concise.query.annotation.QueryField;
import com.concise.query.annotation.QueryTable;
import com.concise.query.core.PageQuery;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@QueryTable(table = UserEntity.TABLE, entityClass = UserEntity.class)
public class UserQuery extends PageQuery {

    private String username;

    @QueryField(and = "(username = #{account} OR email = #{account} OR mobile = #{account})")
    private String account;
}
