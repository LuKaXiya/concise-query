package com.concise.query.mybatis;

import com.concise.query.core.AbstractMockDataAccess;
import com.concise.query.entity.Persistable;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public abstract class AbstractMockMapper<E extends Persistable<I>, I extends Serializable, Q> extends AbstractMockDataAccess<E, I, Q> {

    public AbstractMockMapper(String table) {
        super(table);
    }

}
