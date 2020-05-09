package com.concise.query.mybatis;

import com.concise.query.core.DataAccess;
import com.concise.query.core.QueryBuilder;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface QueryMapper<E, I, Q> extends DataAccess<E, I, Q> {

    @SelectProvider(type = QueryBuilder.class, method = "buildSelect")
    List<E> query(Q query);

    @SelectProvider(type = QueryBuilder.class, method = "buildCount")
    long count(Q query);

    E get(I id);
}