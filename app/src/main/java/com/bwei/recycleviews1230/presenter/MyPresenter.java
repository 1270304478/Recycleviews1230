package com.bwei.recycleviews1230.presenter;


import com.bwei.recycleviews1230.bean.Bean;
import com.bwei.recycleviews1230.model.ModelCallBack;
import com.bwei.recycleviews1230.model.MyModel;
import com.bwei.recycleviews1230.view.ViewCallBack;


public class MyPresenter {

    MyModel myModel = new MyModel();
    ViewCallBack viewCallBack;
    public MyPresenter(ViewCallBack viewCallBack) {
        this.viewCallBack = viewCallBack;
    }

    public void getData() {
        myModel.getData(new ModelCallBack() {
            @Override
            public void success(Bean oldBean) {
                viewCallBack.success(oldBean);
            }

            @Override
            public void failure() {
                viewCallBack.failure();
            }
        });
    }


    //解除绑定
    public void detach(){
        this.viewCallBack = null;
    }
}
