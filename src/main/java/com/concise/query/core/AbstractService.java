package com.concise.query.core;

import com.concise.query.entity.Persistable;
import lombok.experimental.Delegate;

import java.io.Serializable;

public abstract class AbstractService<E extends Persistable<I>, I extends Serializable, Q> implements QueryService<E, Q> {

    @Delegate
    protected DataAccess<E, I, Q> dataAccess;

    public AbstractService(DataAccess<E, I, Q> dataAccess) {
        this.dataAccess = dataAccess;
    }

    public E save(E e) {
        if (e.isNew()) {
            dataAccess.create(e);
        } else {
            dataAccess.update(e);
        }
        return e;
    }

}