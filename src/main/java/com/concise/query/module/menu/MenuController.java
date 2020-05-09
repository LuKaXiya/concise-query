package com.concise.query.module.menu;

import com.concise.query.core.PageList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
@AllArgsConstructor
public class MenuController {

    MenuService menuService;

    @GetMapping("page")
    public PageList<MenuEntity> page(MenuQuery menuQuery) {
        return menuService.page(menuQuery);
    }

    @GetMapping("get")
    public MenuEntity get(Integer id) {
        return menuService.get(id);
    }
}
