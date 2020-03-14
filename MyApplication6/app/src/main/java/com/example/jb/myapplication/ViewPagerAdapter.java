package com.example.jb.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private  final List<Fragment> lstFragment= new ArrayList<>();
    private final List<String>stringList= new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  stringList.get(position);
    }

    @Override
    public int getCount() {
 return stringList.size();
    }
    public void AddFragment (Fragment fragment, String title){
        lstFragment.add(fragment);
        stringList.add(title);
    }

}