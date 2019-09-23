package com.example.materialdesigndemo.example.supportdesign.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.materialdesigndemo.example.ArrayListFragment;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/12/23.
 */
public class MyAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_ITEMS = 4;

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ArrayListFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " +( position + 1);
    }
}
