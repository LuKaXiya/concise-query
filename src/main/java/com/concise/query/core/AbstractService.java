package com.concise.query.core;

import lombok.experimental.Delegate;

import java.io.Serializable;

public abstract class AbstractService<E, I extends Serializable, Q> implements QueryService<E, Q> {

    @Delegate
    protected DataAccess<E, I, Q> dataAccess;

    public AbstractService(DataAccess<E, I, Q> dataAccess) {
        this.dataAccess = dataAccess;
    }

}