package com.concise.query.mybatis;

import com.concise.query.core.AbstractService;
import com.concise.query.entity.Persistable;

import java.io.Serializable;

public abstract class AbstractMyBatisService<E extends Persistable<I>, I extends Serializable, Q> extends AbstractService<E, I, Q> {

    public AbstractMyBatisService(CrudMapper<E, I, Q> queryMapper) {
        super(queryMapper);
    }

}

