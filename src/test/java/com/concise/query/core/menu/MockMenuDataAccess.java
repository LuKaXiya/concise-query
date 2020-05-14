package com.concise.query.core.menu;

import com.concise.query.core.AbstractMockDataAccess;
import com.concise.query.module.menu.MenuEntity;
import com.concise.query.module.menu.MenuMapper;
import com.concise.query.module.menu.MenuQuery;

public class MockMenuDataAccess extends AbstractMockDataAccess<MenuEntity, Integer, MenuQuery> implements MenuMapper {
    public MockMenuDataAccess() {
        super(MenuEntity.TABLE);
    }
}
