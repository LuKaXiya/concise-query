package com.concise.query.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class IntegerId implements Persistable<Integer>, Serializable {

    @Id
    @GeneratedValue
    protected Integer id;

}
