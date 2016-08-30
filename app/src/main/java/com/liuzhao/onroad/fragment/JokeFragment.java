package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.adapter.JokeViewPagerAdapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhao on 2016/3/1.
 */
@ContentView(R.layout.fragment_joke)
public class JokeFragment extends BaseFragment {
    @ViewInject(R.id.vp_joke)
    private ViewPager vp_joke;
    @ViewInject(R.id.tabs_joke)
    private TabLayout tabs_joke;
    private LayoutInflater mInflater;
    private String[] mTitleList = {"文字","图片"};//页卡标题集合

    public static final JokeFragment getInstance() {
        JokeFragment fragment = new JokeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentManager fragmentManager = getFragmentManager();
        mInflater = LayoutInflater.from(mContext);

        tabs_joke.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(JokeTextFragment.getInstance());
        fragments.add(JokeImageFragment.getInstance());

        JokeViewPagerAdapter mAdapter = new JokeViewPagerAdapter(fragmentManager,fragments,mTitleList);
        vp_joke.setAdapter(mAdapter);//给ViewPager设置适配器

        tabs_joke.setupWithViewPager(vp_joke);//将TabLayout和ViewPager关联起来。
        tabs_joke.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
        vp_joke.setCurrentItem(0);


        vp_joke.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vp_joke.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
