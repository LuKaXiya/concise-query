package com.concise.query.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author zzc
 * @date 2020年4月27日17:11:25
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface QueryTable {
    String table();


    Class<?> entityClass();
}
