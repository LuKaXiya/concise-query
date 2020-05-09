package com.concise.query.module.menu;

import com.concise.query.annotation.QueryTable;
import com.concise.query.core.PageQuery;

@QueryTable(table = MenuEntity.TABLE, entityClass = MenuEntity.class)
public class MenuQuery extends PageQuery {
}
