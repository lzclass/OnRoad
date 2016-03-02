package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.activity.BaseActivity;
import com.liuzhao.onroad.adapter.JokeListAdapter;
import com.liuzhao.onroad.entity.JokeBean;
import com.liuzhao.onroad.entity.JokeListResult;
import com.liuzhao.onroad.net.NetCommonCallback;
import com.liuzhao.onroad.net.NetConstants;
import com.liuzhao.onroad.net.NetManager;
import com.liuzhao.onroad.util.JsonUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liuzhao on 2016/3/1.
 */
@ContentView(R.layout.fragment_joke)
public class JokeFragment extends BaseFragment {
    @ViewInject(R.id.swipe_container)
    private SwipeRefreshLayout mSwipeLayout;
    @ViewInject(R.id.lv_joke)
    private ListView lv_joke;
    private JokeListAdapter jokeListAdapter;
    private List<JokeBean> list;

    public static final JokeFragment newInstance() {
        JokeFragment fragment = new JokeFragment();
        return fragment;
    }

    private void initView() {

        // 设置下拉圆圈上的颜色
        mSwipeLayout.setColorSchemeResources(R.color.holo_blue_bright,
                R.color.holo_green_light, R.color.holo_orange_light,
                R.color.holo_red_light);
        mSwipeLayout.setDistanceToTriggerSync(400);// 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeLayout.setProgressBackgroundColorSchemeResource(whiteColor);// 设定下拉圆圈的背景
        mSwipeLayout.setSize(SwipeRefreshLayout.DEFAULT); // 设置圆圈的大小

        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        jokeListAdapter = new JokeListAdapter(getActivity(), list);
        lv_joke.setAdapter(jokeListAdapter);
        getData();
    }


    private void getData() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(NetConstants.METHOD, NetConstants.JOKE);
        NetManager.INSTANCE.doGetHttp(map, new NetCommonCallback(JokeListResult.class, (BaseActivity) getActivity()) {
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                JokeListResult t = JsonUtils.parseJson(result, JokeListResult.class);
                jokeListAdapter.update(t.getResult().getData());

            }

            @Override
            public void onError(Throwable throwable, boolean isOnCallback) {
                super.onError(throwable, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException e) {
                super.onCancelled(e);
            }

            @Override
            public void onFinished() {
                super.onFinished();
            }
        });


    }
}
