package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.adapter.TravelListAdapter;
import com.liuzhao.onroad.view.listview.XListView;

import org.xutils.view.annotation.ViewInject;

public class TravelFragment extends BaseFragment {

	@ViewInject(R.id.swipe_container)
	private SwipeRefreshLayout mSwipeLayout;
	@ViewInject(R.id.lv_travel)
	private XListView lv_travel;
	private TravelListAdapter adapter;

	private int start = 1;

	public static final TravelFragment newInstance() {
		TravelFragment fragment = new TravelFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_travel, container, false);

		return rootView;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

}
