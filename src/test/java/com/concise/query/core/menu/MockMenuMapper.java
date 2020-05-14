package com.concise.query.core.menu;

import com.concise.query.module.menu.MenuEntity;
import com.concise.query.module.menu.MenuMapper;
import com.concise.query.module.menu.MenuQuery;

public class MockMenuMapper extends AbstractMockMapper<MenuEntity, Integer, MenuQuery> implements MenuMapper {
    public MockMenuMapper() {
        super(MenuEntity.TABLE);
    }
}
