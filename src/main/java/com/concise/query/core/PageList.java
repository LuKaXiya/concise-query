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
    public final List<T> list;
    public final long total;
}
