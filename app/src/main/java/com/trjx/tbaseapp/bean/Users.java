package com.trjx.tbaseapp.bean;

import com.trjx.tlibs.bean.resp.RespBaseInfo;

public class Users extends RespBaseInfo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
