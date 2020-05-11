package com.concise.query.core.core;

import com.concise.query.core.CollectionUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CollectionUtilTest {

    @Test
    void first() {
        assertNull(CollectionUtil.first(new LinkedList<>()));
        assertEquals("hello", CollectionUtil.first(Arrays.asList("hello")));
        assertEquals("hello", CollectionUtil.first(Arrays.asList("hello", "world")));
    }
}