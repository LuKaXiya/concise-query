package com.concise.query.module.menu;

import com.concise.query.mybatis.QueryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MenuMapper extends QueryMapper<MenuEntity, Integer, MenuQuery> {

    @Select("select * from menu where id = #{id}")
    MenuEntity get(@Param("id") Integer id);

}
