package com.example.newsapp.Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.Fragments.EntertainmentFragment;
import com.example.newsapp.Fragments.HealthFragment;
import com.example.newsapp.Fragments.HomeFragment;
import com.example.newsapp.Fragments.ScienceFragment;
import com.example.newsapp.Fragments.SportsFragment;
import com.example.newsapp.Fragments.TechnologyFragment;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private final ArrayList<String> titleList = new ArrayList<>();
    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

//        switch (position){
//
//            case 0:
//                Log.d("POSITION",String.valueOf(position));
//                return new HomeFragment();
//            case 1:
//                Log.d("POSITION",String.valueOf(position));
//                return new SportsFragment();
//            case 2:
//                Log.d("POSITION",String.valueOf(position));
//                return new HealthFragment();
//            case 3:
//                Log.d("POSITION",String.valueOf(position));
//                return new ScienceFragment();
//            case 4:
//                Log.d("POSITION",String.valueOf(position));
//                return new EntertainmentFragment();
//            case 5:
//                Log.d("POSITION",String.valueOf(position));
//                return new TechnologyFragment();
//            default:
//                return null;
//        }
        return fragmentArrayList.get(position);

    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment,String title){
        fragmentArrayList.add(fragment);
        titleList.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
