package com.concise.query.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @date 2020年5月7日
 */
@Getter
@AllArgsConstructor
public class PageList<T> {
    private final List<T> list;
    private final long total;
}
