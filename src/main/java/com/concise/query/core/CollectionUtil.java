package com.concise.query.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectionUtil {
    public static <E> E first(Iterable<E> iterable) {
        Iterator<E> iterator = iterable.iterator();
        try {
            return iterator.hasNext() ? iterator.next() : null;
        } finally {
            if (iterator.hasNext()) {
                log.warn("Find more than one element of {}", iterator.next().getClass());
            }
        }
    }
}
