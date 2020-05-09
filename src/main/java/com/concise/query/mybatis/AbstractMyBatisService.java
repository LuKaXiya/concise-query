package com.concise.query.mybatis;

import com.concise.query.core.AbstractService;

import java.io.Serializable;

public abstract class AbstractMyBatisService<E, I extends Serializable, Q> extends AbstractService<E, I, Q> {

    public AbstractMyBatisService(QueryMapper<E, I, Q> queryMapper) {
        super(queryMapper);
    }

}

