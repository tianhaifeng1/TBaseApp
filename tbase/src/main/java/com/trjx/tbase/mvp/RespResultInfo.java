package com.trjx.tbase.mvp;

import com.trjx.tlibs.bean.resp.RespBaseInfo;

/**
 * 相应对象需继承此对象
 */
public abstract class RespResultInfo  extends RespBaseInfo {

   public abstract int getResultState();

   public abstract String getRemindMessage();

}
