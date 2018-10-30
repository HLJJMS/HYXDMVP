package com.example.administrator.hyxdmvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.hyxdmvp.fragment.view.home.HomeFragment;
import com.example.administrator.hyxdmvp.fragment.view.my.MyFragment;
import com.example.administrator.hyxdmvp.fragment.OkFragment;
import com.example.administrator.hyxdmvp.fragment.SetFragment;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<Fragment>();


    public TabAdapter(FragmentManager fm) {
        super(fm);
        list.add(new HomeFragment());
        list.add(new OkFragment());
        list.add(new SetFragment());
        list.add(new MyFragment());
    }


    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
