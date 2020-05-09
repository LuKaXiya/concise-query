package com.concise.query.module.menu;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = MenuEntity.TABLE)
public class MenuEntity {
    public static final String TABLE = "menu";

    @Id
    @GeneratedValue
    protected Integer id;

}
