package com.concise.query.entity;

import java.beans.Transient;

public interface Persistable<I> {
    I getId();

    @Transient
    default boolean isNew() {
        return getId() == null;
    }
}
