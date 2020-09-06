package com.trjx.tbaseapp.bean.req;

import com.trjx.tlibs.bean.req.ReqBaseInfo;

public class ReqTestInfo extends ReqBaseInfo {

    private String timestamp;
    private String userId;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "timestamp=" + timestamp +
                ",userId=" + userId ;
    }

}
