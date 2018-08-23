package com.mangomirror.app.rxjavawithretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mangomirror.app.rxjavawithretrofit.Model.PostObject;
import com.mangomirror.app.rxjavawithretrofit.Model.myInterface.CryptocurrencyService;
import com.mangomirror.app.rxjavawithretrofit.Model.myInterface.RetrofitClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    CryptocurrencyService cryptocurrencyService;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getInstance();
        cryptocurrencyService = retrofit.create(CryptocurrencyService.class);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        fetchData();

    }


    private void fetchData() {
        compositeDisposable.add(cryptocurrencyService.getPostObjectResponse()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<PostObject>>() {
            @Override
            public void accept(List<PostObject> postObjectList) throws Exception {
                displayData(postObjectList);
            }
        }));
    }

    private void displayData(List<PostObject> postObjectList) {
        PostRecyclerView postRecyclerView = new PostRecyclerView(this,postObjectList);
        recyclerView.setAdapter(postRecyclerView);
    }

}
