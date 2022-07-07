package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;

import com.example.newsapp.Adapter.PagerAdapter;
import com.example.newsapp.Fragments.EntertainmentFragment;
import com.example.newsapp.Fragments.HealthFragment;
import com.example.newsapp.Fragments.HomeFragment;
import com.example.newsapp.Fragments.ScienceFragment;
import com.example.newsapp.Fragments.SportsFragment;
import com.example.newsapp.Fragments.TechnologyFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mhome,msports,mhealth,mscience,mentertainment,mtechnology;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mhome = findViewById(R.id.home);
        msports = findViewById(R.id.sports);
        mhealth = findViewById(R.id.health);
        mscience = findViewById(R.id.science);
        mentertainment = findViewById(R.id.entertainment);
        mtechnology = findViewById(R.id.technology);
        ViewPager viewPager = findViewById(R.id.fragment);
        tabLayout=findViewById(R.id.category);

//        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);
//        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pagerAdapter.addFragment(new HomeFragment(),"HOME");
        pagerAdapter.addFragment(new SportsFragment(),"SPORTS");
        pagerAdapter.addFragment(new HealthFragment(),"HEALTH");
        pagerAdapter.addFragment(new ScienceFragment(),"SCIENCE");
        pagerAdapter.addFragment(new EntertainmentFragment(),"ENTERTAINMENT");
        pagerAdapter.addFragment(new TechnologyFragment(),"TECHNOLOGY");
        viewPager.setAdapter(pagerAdapter);



//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
//                    pagerAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}