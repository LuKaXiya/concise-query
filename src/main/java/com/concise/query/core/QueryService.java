package com.concise.query.core;

import java.util.List;

public interface QueryService<E, Q> {

    List<E> query(Q query);

    long count(Q query);

    default PageList<E> page(Q query) {
        return new PageList<>(query(query), count(query));
    }

}
