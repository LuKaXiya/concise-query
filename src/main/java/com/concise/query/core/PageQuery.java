package com.concise.query.core;

import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
public class PageQuery {

    private Integer pageSize;

    private Integer pageNumber;

    public Integer getPageNumber() {
        return getDefault(pageNumber, 0);
    }

    public Integer getPageSize() {
        return getDefault(pageSize, 10);
    }

    private Integer getDefault(Integer pageSize, int i) {
        if (pageSize == null) {
            return null;
        } else {
            return pageSize < 0 ? i : pageSize;
        }
    }

    public int getOffset() {
        return getPageSize() * getPageNumber();
    }

    public boolean needPaging() {
        return getPageNumber() != null && getPageSize() != null;
    }
}
