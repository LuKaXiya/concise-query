package com.concise.query.core;

import com.concise.query.entity.Persistable;
import lombok.experimental.Delegate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public List<E> save(Iterable<E> entities) {
        List<E> result = new ArrayList<>();
        if (entities == null) {
            return result;
        } else {
            for (E entity : entities) {
                result.add(this.save(entity));
            }
            return result;
        }
    }

}