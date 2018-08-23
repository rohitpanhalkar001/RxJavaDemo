package com.mangomirror.app.rxjavawithretrofit.Model.myInterface;

import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mindbowser-BA on 13-Aug-18.
 */

public class RetrofitClient {
    private static Retrofit ourInstance;

    public static Retrofit getInstance() {
        if (ourInstance == null)
              ourInstance = new Retrofit.Builder()
                      .baseUrl("http://jsonplaceholder.typicode.com/")
                      .addConverterFactory(GsonConverterFactory.create())
                      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                      .build();
        return ourInstance;
    }

    private RetrofitClient() {
    }
}
