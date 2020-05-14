package com.concise.query.core;

import java.io.Serializable;
import java.util.List;

public interface DataAccess<E, I extends Serializable, Q> {

    List<E> query(Q query);

    long count(Q query);

    E get(I id);

    void delete(I id);

    void create(E e);

    void update(E e);

}
