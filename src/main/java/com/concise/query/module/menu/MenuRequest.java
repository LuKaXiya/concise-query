package com.concise.query.module.menu;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class MenuRequest {

    private Integer parentId;

    private String menuName;

    private String memo;

    private Boolean valid = true;

    public MenuEntity toEntity() {
        MenuEntity menuEntity = new MenuEntity();
        BeanUtils.copyProperties(this, menuEntity);
        return menuEntity;
    }
}
