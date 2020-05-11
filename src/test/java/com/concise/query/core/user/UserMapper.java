package com.concise.query.core.user;

import com.concise.query.mybatis.MapperTable;
import com.concise.query.mybatis.QueryMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@MapperTable(UserEntity.TABLE)
public interface UserMapper extends QueryMapper<UserEntity, Integer, UserQuery> {

}
