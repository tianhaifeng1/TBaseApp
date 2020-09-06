package com.trjx.tbaseapp.test;

import androidx.annotation.NonNull;

import com.trjx.tbaseapp.base.DemoPresenter;
import com.trjx.tlibs.assist.ImgPaths;

import java.util.ArrayList;
import java.util.List;

public class RvPresenter extends DemoPresenter<RvView> {

    public RvPresenter(@NonNull RvView view) {
        super(view);
    }


    private boolean isLoad = false;

    public void testDate(int page) {

        List<TestBean> list = new ArrayList<>();
        if (isLoad) {
            if (page < 3) {
                TestBean testBean = null;
                for (int i = 0; i < 20; i++) {
                    testBean = new TestBean();
                    testBean.setName("name" + (i + 10));
                    testBean.setAddress("address" + (i + 100));
                    testBean.setAge(1000);
                    list.add(testBean);
                }
            }
        }else {
            isLoad = true;
        }

        getView().testSuccess(list);
    }

    public void testMoreDate(int page) {

        List<TestMoreBean> list = new ArrayList<>();
        if (isLoad) {
            if (page < 3) {
                TestMoreBean testBean = null;
                for (int i = 0; i < 20; i++) {
                    testBean = new TestMoreBean();
                    testBean.setName("name" + (i + 10));
                    testBean.setAddress("address" + (i + 100));
                    testBean.setAge(1000);
                    testBean.setPath(ImgPaths.path[i % ImgPaths.path.length]);
                    testBean.setItemType(i % 2 == 0 ? 1 : 2);
                    list.add(testBean);
                }
            }
        }else {
            isLoad = true;
        }

        getView().testSuccess(list);
    }

}
