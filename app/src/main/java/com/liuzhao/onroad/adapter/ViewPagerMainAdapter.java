package com.liuzhao.onroad.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.liuzhao.onroad.activity.Main2Activity;
import com.liuzhao.onroad.fragment.MyInfoFragment;
import com.liuzhao.onroad.fragment.StoryFragment;


public class ViewPagerMainAdapter extends FragmentPagerAdapter {

	public ViewPagerMainAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {
		case Main2Activity.TAB_INDEX_1:
			return StoryFragment.newInstance();
		case Main2Activity.TAB_INDEX_2:
			return StoryFragment.newInstance();
		case Main2Activity.TAB_INDEX_3:
			return StoryFragment.newInstance();
		case Main2Activity.TAB_INDEX_4:
			return MyInfoFragment.newInstance();
		default:
			break;
		}
		 throw new IllegalStateException("No fragment at position " + arg0);
	}

	@Override
	public int getCount() {
		return Main2Activity.TAB_COUNT;
	}

}
