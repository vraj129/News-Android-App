package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DescActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Button btn;
    String urltoNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        imageView = findViewById(R.id.imageD);
        textView = findViewById(R.id.desc);
        btn = findViewById(R.id.readbtn);
        Intent i = getIntent();
        Glide.with(this)
                .load(i.getStringExtra("url"))
                .into(imageView);
        textView.setText(i.getStringExtra("desc"));
        urltoNews = i.getStringExtra("urltonews");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DescActivity.this,WebViewActivity.class);
                intent.putExtra("url_to_news",urltoNews);
                startActivity(intent);
            }
        });
    }
}