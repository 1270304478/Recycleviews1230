package com.bwei.recycleviews1230.model;


import com.bwei.recycleviews1230.bean.Bean;
import com.bwei.recycleviews1230.utils.IApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MyModel {
    public void getData(final ModelCallBack modelCallBack) {
        IApplication.service.get("homepage").enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean bean = response.body();
                modelCallBack.success(bean);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                modelCallBack.failure();

            }
        });
    }
}
