package com.trjx.tbaseapp.base;

import android.util.Log;

import androidx.annotation.NonNull;

import com.trjx.tbase.mvp.TPresenter;
import com.trjx.tbase.mvp.TView;
import com.trjx.tbaseapp.assist.DemoConstant;
import com.trjx.tbaseapp.http.DemoModel;
import com.trjx.tlibs.uils.MD5Utils;

import java.text.SimpleDateFormat;

public class DemoPresenter<V extends TView> extends TPresenter<V , DemoModel> {

    public DemoPresenter(@NonNull V view) {
        super(view);
    }

    protected String getCurrentTimeStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(System.currentTimeMillis());
    }

    /**
     * 把数组所有元素排序，并按照“参数参数值”的模式拼接成字符串
     * @param prestr
     * @return
     */
    protected String getSignMD5String(String prestr) {
        Log.i("tong", "-befour----" + prestr);
        prestr = MD5Utils.getMD5(DemoConstant.secret + prestr + DemoConstant.secret, true);
        Log.i("tong", "-after----" + prestr);
        return prestr;
    }

}
