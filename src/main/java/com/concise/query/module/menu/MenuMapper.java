package com.concise.query.module.menu;

import com.concise.query.mybatis.MapperTable;
import com.concise.query.mybatis.QueryMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@MapperTable(MenuEntity.TABLE)
public interface MenuMapper extends QueryMapper<MenuEntity, Integer, MenuQuery> {

}
