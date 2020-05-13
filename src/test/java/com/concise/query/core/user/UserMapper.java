package com.concise.query.core.user;

import com.concise.query.mybatis.CrudMapper;
import com.concise.query.mybatis.MapperTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@MapperTable(UserEntity.TABLE)
public interface UserMapper extends CrudMapper<UserEntity, Integer, UserQuery> {

}
