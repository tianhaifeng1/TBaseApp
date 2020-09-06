package com.trjx.tbaseapp.bean.req;

import com.trjx.tlibs.bean.req.ReqBaseInfo;

public class ReqTest2Info extends ReqBaseInfo {

    private String timestamp;

    private int types;
    private int relatedCatids;
    private int page;
    private int pageSize;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    public int getRelatedCatids() {
        return relatedCatids;
    }

    public void setRelatedCatids(int relatedCatids) {
        this.relatedCatids = relatedCatids;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return
                ",page=" + page +
                        ",pageSize=" + pageSize +
                        ",relatedCatids=" + relatedCatids +
                        ",timestamp=" + timestamp +
                        ",types=" + types
                ;
    }
}
