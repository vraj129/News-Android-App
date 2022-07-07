package com.example.newsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.newsapp.Adapter.Adapter;
import com.example.newsapp.Model.NewsModel;
import com.example.newsapp.R;
import com.example.newsapp.ViewModel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    List<NewsModel> newsModelArrayList;
    Adapter  adapter;
    private NewsViewModel newsViewModel;
    private RecyclerView recyclerViewHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewHome = view.findViewById(R.id.recyclerhome);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewHome.setLayoutManager(layoutManager);
        newsModelArrayList = new ArrayList<>();
        newsViewModel = new ViewModelProvider(getActivity()).get(NewsViewModel.class);
        newsViewModel.getNewsList().observe(getActivity(), new Observer<List<NewsModel>>() {
            @Override
            public void onChanged(List<NewsModel> newsModels) {
               // Log.d("HOME",newsModels.toString());
                newsModelArrayList = newsModels;
                adapter = new Adapter(getActivity(),newsModelArrayList);
                recyclerViewHome.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
        newsViewModel.makeApiCall();
        return view;
    }
}