package com.example.newsapp.Network;

import com.example.newsapp.Model.NewsJSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
//?country=de&category=business&apiKey=855e9d8134d54f1cb0b5a7a55584e471
    @GET("top-headlines")
    Call<NewsJSONResponse> getNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<NewsJSONResponse> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );
}
