package com.concise.query.core;

import java.util.List;

public interface DataAccess<E, I, Q> {

    List<E> query(Q query);

    long count(Q query);

    E get(I id);

//    default PageList<E> page(Q query) {
//        return new PageList<>(query(query), count(query));
//    }
}
