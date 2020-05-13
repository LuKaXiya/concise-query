package com.concise.query.core;

import java.util.List;

public interface DataAccess<E, I, Q> {

    List<E> query(Q query);

    long count(Q query);

    E get(I id);

    void delete(I id);

    void create(E e);

    void update(E e);

}
