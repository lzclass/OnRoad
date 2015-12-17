package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.adapter.StoryListAdapter;
import com.liuzhao.onroad.entity.StoryListResult;
import com.liuzhao.onroad.view.listview.XListView;

import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * @description
 * @author liuzhao
 * @date 2015-12-8下午3:37:46
 */
public class StoryFragment extends BaseFragment {
	@ViewInject(R.id.swipe_container)
	private SwipeRefreshLayout mSwipeLayout;
	@ViewInject(R.id.lv_story)
	private XListView lv_story;
	private StoryListAdapter storyListAdapter;
	private List<StoryListResult> list;

	public static final StoryFragment newInstance() {
		StoryFragment fragment = new StoryFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_story, container, false);
		initView();
		storyListAdapter = new StoryListAdapter(mActivity, list);
		lv_story.setAdapter(storyListAdapter);
		lv_story.setPullLoadHide();
		lv_story.setPullRefreshEnable(false);
		return rootView;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	private void initView() {
		mSwipeLayout = (SwipeRefreshLayout) rootView
				.findViewById(R.id.swipe_container);
		lv_story = (XListView) rootView.findViewById(R.id.lv_story);
		// 设置下拉圆圈上的颜色
		mSwipeLayout.setColorSchemeResources(R.color.holo_blue_bright,
				R.color.holo_green_light, R.color.holo_orange_light,
				R.color.holo_red_light);
		mSwipeLayout.setDistanceToTriggerSync(400);// 设置手指在屏幕下拉多少距离会触发下拉刷新
		mSwipeLayout.setProgressBackgroundColor(whiteColor); // 设定下拉圆圈的背景
		mSwipeLayout.setSize(SwipeRefreshLayout.DEFAULT); // 设置圆圈的大小

		mSwipeLayout.setOnRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						// 获得数据停止刷新
						mSwipeLayout.setRefreshing(false);
					}
				}, 5000);
			}
		});
	}
}
