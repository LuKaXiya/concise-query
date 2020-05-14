package com.concise.query.module.menu;

import com.concise.query.core.PageList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
@AllArgsConstructor
public class MenuController {

    MenuService menuService;

    @GetMapping("page")
    public PageList<MenuResponse> page(MenuQuery menuQuery) {
        return menuService.page(menuQuery, MenuResponse::of);
    }

    @GetMapping("get")
    public MenuResponse get(Integer id) {
        return MenuResponse.of(menuService.get(id));
    }

    @PostMapping("save")
    public void save(MenuRequest menuRequest) {
        menuService.save(menuRequest.toEntity());
    }
}
