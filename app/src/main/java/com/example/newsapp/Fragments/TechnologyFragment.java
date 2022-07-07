package com.example.newsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.Adapter.Adapter;
import com.example.newsapp.Model.NewsJSONResponse;
import com.example.newsapp.Model.NewsModel;
import com.example.newsapp.Network.ApiService;
import com.example.newsapp.Network.RetroInstance;
import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TechnologyFragment extends Fragment {

    List<NewsModel> newsModelArrayList;
    Adapter adapter;
    private RecyclerView recyclerViewTechnology;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_technology, container, false);
        recyclerViewTechnology = view.findViewById(R.id.recyclertechnology);
        recyclerViewTechnology.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsModelArrayList = new ArrayList<>();

        adapter = new Adapter(getContext(),newsModelArrayList);
        recyclerViewTechnology.setAdapter(adapter);
        makeCall("technology");

        return view;



    }
    private void makeCall(String category){
        final String api_key = "855e9d8134d54f1cb0b5a7a55584e471";
        String country="in";
        ApiService service = RetroInstance.getRetrofitClient().create(ApiService.class);
        Call<NewsJSONResponse> call2 =service.getCategoryNews(country,category,100,api_key);
        call2.enqueue(new Callback<NewsJSONResponse>() {
            @Override
            public void onResponse(Call<NewsJSONResponse> call, Response<NewsJSONResponse> response) {
                newsModelArrayList.addAll(response.body().getNewsModels());
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<NewsJSONResponse> call, Throwable t) {

            }
        });
    }
}