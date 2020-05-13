package com.concise.query.module.menu;

import com.concise.query.entity.IntegerId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = MenuEntity.TABLE)
public class MenuEntity extends IntegerId {
    public static final String TABLE = "menu";

    private Integer parentId;

    private String menuName;

    private String memo;

    private Boolean valid;

}
