package com.mangomirror.app.rxjavawithretrofit.Model.myInterface;

import com.mangomirror.app.rxjavawithretrofit.Model.PostObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Mindbowser-BA on 13-Aug-18.
 */

public interface CryptocurrencyService  {

    @GET("posts")
    Observable<List<PostObject>> getPostObjectResponse();
}
