package com.example.newsapp.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.Model.NewsJSONResponse;
import com.example.newsapp.Model.NewsModel;
import com.example.newsapp.Network.ApiService;
import com.example.newsapp.Network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    private static final String api_key = "855e9d8134d54f1cb0b5a7a55584e471";
    String country="in";
     MutableLiveData<List<NewsModel>> newsList;
     MutableLiveData<List<NewsModel>> categoryNewsList;

    public NewsViewModel() {
        newsList = new MutableLiveData<>();
        categoryNewsList = new MutableLiveData<>();
    }

    public MutableLiveData<List<NewsModel>> getNewsList() {
        return newsList;
    }

    public MutableLiveData<List<NewsModel>> getCategoryNewsList() {
        return categoryNewsList;
    }

    public void makeApiCall(){
        ApiService service = RetroInstance.getRetrofitClient().create(ApiService.class);
        Call<NewsJSONResponse> call1 = service.getNews(country,100,api_key);
        call1.enqueue(new Callback<NewsJSONResponse>() {
            @Override
            public void onResponse(Call<NewsJSONResponse> call, Response<NewsJSONResponse> response) {
                    newsList.postValue(response.body().getNewsModels());
            }

            @Override
            public void onFailure(Call<NewsJSONResponse> call, Throwable t) {

            }
        });
    }
    public void makeApiCall(String category){
        ApiService service = RetroInstance.getRetrofitClient().create(ApiService.class);
        Call<NewsJSONResponse> call2 =service.getCategoryNews(country,category,100,api_key);
        call2.enqueue(new Callback<NewsJSONResponse>() {
            @Override
            public void onResponse(Call<NewsJSONResponse> call, Response<NewsJSONResponse> response) {
                categoryNewsList.setValue(response.body().getNewsModels());
            }
            @Override
            public void onFailure(Call<NewsJSONResponse> call, Throwable t) {

            }
        });
    }
}
