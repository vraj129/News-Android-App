package com.example.newsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.DescActivity;
import com.example.newsapp.Model.NewsModel;
import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<NewsModel> newsModels;

    public Adapter(Context context, List<NewsModel> newsModels) {
        this.context = context;
        this.newsModels = newsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.heading.setText(newsModels.get(position).getTitle());
        holder.description.setText(newsModels.get(position).getDescription());
        Glide.with(context)
                .load(newsModels.get(position).getUrlToImage())
                .into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DescActivity.class);
                i.putExtra("desc",newsModels.get(position).getDescription());
                i.putExtra("url",newsModels.get(position).getUrlToImage());
                i.putExtra("urltonews",newsModels.get(position).getUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(newsModels == null){
            return 0;
        }
        return newsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading,description;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            heading = itemView.findViewById(R.id.heading);
            description = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
