package com.example.newsapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsJSONResponse {
    @SerializedName("articles")
    private ArrayList<NewsModel> newsModels;

    public NewsJSONResponse(ArrayList<NewsModel> newsModels) {
        this.newsModels = newsModels;
    }

    public ArrayList<NewsModel> getNewsModels() {
        return newsModels;
    }

    public void setNewsModels(ArrayList<NewsModel> newsModels) {
        this.newsModels = newsModels;
    }

    @Override
    public String toString() {
        return "NewsJSONResponse{" +
                "newsModels=" + newsModels +
                '}';
    }
}
