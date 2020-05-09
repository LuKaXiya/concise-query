package com.concise.query.module.user;

import com.concise.query.annotation.QueryField;
import com.concise.query.annotation.QueryTable;
import com.concise.query.core.PageQuery;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@QueryTable(table = "user",entityClass = UserEntity.class)
public class UserQuery extends PageQuery {
    private String username;

    @QueryField(and = "(username = #{account} OR email = #{account} OR mobile = #{account})")
    private String account;
}
