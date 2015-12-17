package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuzhao.onroad.R;


/**
 * @author liuzhao on 2015-9-22下午4:51:45 邮箱：63993048@qq.com 个人信息
 */
public class MyInfoFragment extends BaseFragment {

	public static final MyInfoFragment newInstance() {
		MyInfoFragment fragment = new MyInfoFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_my_info, container, false);
		return rootView;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
}
