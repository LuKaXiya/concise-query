package com.concise.query.module.user;

import com.concise.query.annotation.QueryField;
import com.concise.query.annotation.QueryTable;
import com.concise.query.core.PageQuery;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@QueryTable(table = UserEntity.TABLE, entityClass = UserEntity.class)
public class UserQuery extends PageQuery {

    private List<Integer> idIn;

    private String username;

    @QueryField(and = "(username = #{account} OR email = #{account} OR mobile = #{account})")
    private String account;

    private String mobile;

    private String usernameLike;

    public String getUsernameLike() {
        return usernameLike == null ? null : "%" + usernameLike + "%";
    }
}
