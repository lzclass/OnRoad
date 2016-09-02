package com.liuzhao.onroad.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by liuzhao on 2016/8/30.
 */
public class JokeViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] mTitleList;

    public JokeViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] mTitleList) {
        super(fm);
        this.fragments = fragments;
        this.mTitleList = mTitleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();//页卡数
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;//官方推荐写法
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList[position % mTitleList.length];//页卡标题
    }

}
