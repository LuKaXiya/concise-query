package com.concise.query.core.user;

import com.concise.query.mybatis.QueryMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends QueryMapper<UserEntity, Integer, UserQuery> {

}
