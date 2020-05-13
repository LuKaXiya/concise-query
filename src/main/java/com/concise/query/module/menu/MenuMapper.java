package com.concise.query.module.menu;

import com.concise.query.mybatis.CrudMapper;
import com.concise.query.mybatis.MapperTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@MapperTable(MenuEntity.TABLE)
public interface MenuMapper extends CrudMapper<MenuEntity, Integer, MenuQuery> {

}
