package com.bwei.recycleviews1230.utils;

import android.app.Application;

import com.bwei.recycleviews1230.IGetDataService;
import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IApplication extends Application{

    public static IGetDataService service;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化配置中
        Fresco.initialize(this);

        //http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://result.eolinker.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(IGetDataService.class);


    }
}
