package com.liuzhao.onroad.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuzhao.onroad.R;

public class BaseFragment extends Fragment {

	/** 日志输出标识 */
	protected final String TAG = this.getClass().getSimpleName();
	protected Activity mActivity;
	protected View rootView;
	protected int whiteColor = R.color.white;

	public BaseFragment() {

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.mActivity = activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (rootView != null) {
			/*
			 * 缓存的rootView需要判断是否已经被加过parent，
			 * 如果有parent需要从parent删除，要不然会发生这个RootView已经有parent的错误。
			 */
			ViewGroup parent = (ViewGroup) rootView.getParent();
			if (parent != null) {
				parent.removeView(rootView);
			}
			return rootView;
		}
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

	}

}