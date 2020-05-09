package com.concise.query.module.menu;

import com.concise.query.mybatis.AbstractMyBatisService;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends AbstractMyBatisService<MenuEntity, Integer, MenuQuery> {

    public MenuService(MenuMapper menuMapper) {
        super(menuMapper);
    }

}
