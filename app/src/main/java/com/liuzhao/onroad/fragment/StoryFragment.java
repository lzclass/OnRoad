package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.widget.ListView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.adapter.StoryListAdapter;
import com.liuzhao.onroad.entity.Article;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhao
 * @description
 * @date 2015-12-8下午3:37:46
 */
@ContentView(R.layout.fragment_story)
public class StoryFragment extends BaseFragment {
    @ViewInject(R.id.swipe_container)
    private SwipeRefreshLayout mSwipeLayout;
    @ViewInject(R.id.lv_story)
    private ListView lv_story;
    private StoryListAdapter storyListAdapter;
    private List<Article> list;

    public static final StoryFragment newInstance() {
        StoryFragment fragment = new StoryFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        list = new ArrayList<Article>();
        for(int i = 0;i<10;i++){
            Article result = new Article();
            result.setAuthor("作者");
            list.add(result);
        }
        storyListAdapter = new StoryListAdapter(getActivity(), list);
        lv_story.setAdapter(storyListAdapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView() {

        // 设置下拉圆圈上的颜色
        mSwipeLayout.setColorSchemeResources(R.color.holo_blue_bright,
                R.color.holo_green_light, R.color.holo_orange_light,
                R.color.holo_red_light);
        mSwipeLayout.setDistanceToTriggerSync(400);// 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeLayout.setProgressBackgroundColorSchemeResource(whiteColor);// 设定下拉圆圈的背景
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
                }, 3000);
            }
        });
    }
}
