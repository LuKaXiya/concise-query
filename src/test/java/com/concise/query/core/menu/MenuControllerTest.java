package com.concise.query.core.menu;

import com.concise.query.module.menu.MenuController;
import com.concise.query.module.menu.MenuRequest;
import com.concise.query.module.menu.MenuResponse;
import com.concise.query.module.menu.MenuService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControllerTest {


    @Test
    void get() {
        MockMenuDataAccess menuMapper = new MockMenuDataAccess();
        MenuController menuController = new MenuController(new MenuService(menuMapper));

        MenuRequest menuRequest = new MenuRequest();
        menuRequest.setParentId(0);
        menuRequest.setMenuName("root");
        menuController.save(menuRequest);

        MenuResponse menuResponse = menuController.get(1);
        assertEquals("root", menuResponse.getMenuName());
        assertEquals(0, (int) menuResponse.getParentId());
    }
}
