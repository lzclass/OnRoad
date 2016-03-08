package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.activity.BaseActivity;
import com.liuzhao.onroad.adapter.JokeListAdapter;
import com.liuzhao.onroad.common.CommonConstants;
import com.liuzhao.onroad.entity.JokeBean;
import com.liuzhao.onroad.entity.JokeListResult;
import com.liuzhao.onroad.net.NetCommonCallback;
import com.liuzhao.onroad.net.NetConstants;
import com.liuzhao.onroad.net.NetManager;
import com.liuzhao.onroad.util.JsonUtils;
import com.liuzhao.onroad.util.Utils;

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
    private int page = 1;
    private int pageSize = 10;
    private String time;

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

    //    请求参数说明：
//    名称 	类型 	必填 	说明
//    sort 	string 	是 	类型，desc:指定时间之前发布的，asc:指定时间之后发布的
//    page 	int 	否 	当前页数,默认1
//    pagesize 	int 	否 	每次返回条数,默认1,最大20
//    time 	string 	是 	时间戳（10位），如：1418816972
//    key 	string 	是 	您申请的key
    private void getData() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(NetConstants.METHOD, NetConstants.JOKE);
        map.put("sort", "asc");
        map.put("page", page + "");
        map.put("pagesize", pageSize + "");
        map.put("time", time);
        map.put("key", CommonConstants.JUHE_KEY);
        NetManager.INSTANCE.doGetHttp(map, new NetCommonCallback(JokeListResult.class, (BaseActivity) getActivity()) {
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                JokeListResult t = JsonUtils.parseJson(result, JokeListResult.class);
                if (t.getResult().getData() == null || t.getResult().getData().size() == 0) {
                    return;
                }
                list = t.getResult().getData();
                for (int i = 0; i < 10; i++) {
                    JokeBean bean = new JokeBean();
                    bean.setContent("我女朋友气跑了＂\r\n＂怎么回事？严重吗？你怎么着她了？＂\r\n＂不严重，我只是很久没用了");
                    bean.setHashId("03a6095c18e1d6fe7e2c19b2a20d03d1");
                    bean.setUnixtime("1418814837");
                    bean.setUpdatetime("2014-12-17 19:13:57");
                }
                jokeListAdapter.update(list);

            }

            @Override
            public void onError(Throwable throwable, boolean isOnCallback) {
                super.onError(throwable, isOnCallback);
                Utils.showToast("返回数据错误");
                for (int i = 0; i < 10; i++) {
                    JokeBean bean = new JokeBean();
                    bean.setContent("我女朋友气跑了＂\r\n＂怎么回事？严重吗？你怎么着她了？＂\r\n＂不严重，我只是很久没用了");
                    bean.setHashId("03a6095c18e1d6fe7e2c19b2a20d03d1");
                    bean.setUnixtime("1418814837");
                    bean.setUpdatetime("2014-12-17 19:13:57");
                }
                jokeListAdapter.update(list);
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
