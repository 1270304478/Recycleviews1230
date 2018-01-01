package com.bwei.recycleviews1230;

import com.bwei.recycleviews1230.bean.Bean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Menglucywhh on 2017/12/4.
 */

public interface IGetDataService {

  // http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage
    @GET("/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611")
    Call<Bean> get(@Query("uri") String uri);

}
