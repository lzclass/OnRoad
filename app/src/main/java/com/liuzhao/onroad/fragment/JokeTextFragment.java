package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.LinearLayout;

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
import com.liuzhao.onroad.view.listview.XListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liuzhao on 2016/3/1.
 */
@ContentView(R.layout.fragment_joke_text)
public class JokeTextFragment extends BaseFragment {
    @ViewInject(R.id.swipe_container)
    private SwipeRefreshLayout mSwipeLayout;
    @ViewInject(R.id.lv_joke)
    private XListView lv_joke;
    private JokeListAdapter jokeListAdapter;
    private List<JokeBean> list;
    private int page = 1;
    private int pageSize = 10;
    private String time;
    private ViewPager vp_joke;
    /*是否是初始化*/
    private boolean isInit = false;
    @ViewInject(R.id.ll_no_data)
    private LinearLayout ll_no_data;

    public static final JokeFragment getInstance() {
        JokeFragment fragment = new JokeFragment();
        return fragment;
    }

    private void initView() {
        lv_joke.setEmptyView(ll_no_data);
        lv_joke.setPullRefreshEnable(true);
        lv_joke.setPullLoadEnable(true);

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
                page = 1;
                getData();
            }
        });
        jokeListAdapter = new JokeListAdapter(getActivity(), list);
        lv_joke.setAdapter(jokeListAdapter);
        getData();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

    }

    //实现了懒加载+数据缓存的效果
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isInit)//isInit  默认是false 没有初始化控件过，不然会空指针
        {
            initView();
        } else {
            isInit = true;//不可见，设置为false 第二次可见的时候不执行加载数据的方法
        }
    }

    //    请求参数说明：
//    名称 	类型 	必填 	说明
//    sort 	string 	是 	类型，desc:指定时间之前发布的，asc:指定时间之后发布的
//    page 	int 	否 	当前页数,默认1
//    pagesize 	int 	否 	每次返回条数,默认1,最大20
//    time 	string 	是 	时间戳（10位），如：1418816972
//    key 	string 	是 	您申请的key
    private void getData() {
        time = System.currentTimeMillis() + "";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(NetConstants.METHOD, NetConstants.JOKE_CONTENT);
        map.put("page", page + "");
        map.put("pagesize", pageSize + "");
        map.put("key", CommonConstants.JUHE_JOKE_KEY);
        NetManager.INSTANCE.doGetHttp(map, new NetCommonCallback(JokeListResult.class, (BaseActivity) getActivity()) {
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                JokeListResult t = JsonUtils.parseJson(result, JokeListResult.class);
                if (t.getResult().getData() == null || t.getResult().getData().size() == 0) {
                    return;
                }
                list = t.getResult().getData();
                jokeListAdapter.update(list);
                mSwipeLayout.setRefreshing(false);

            }

            @Override
            public void onError(Throwable throwable, boolean isOnCallback) {
                super.onError(throwable, isOnCallback);
                Utils.showMyToast("onError");
                mSwipeLayout.setRefreshing(false);
            }

            @Override
            public void onCancelled(CancelledException e) {
                super.onCancelled(e);
                Utils.showMyToast("onCancelled");
                mSwipeLayout.setRefreshing(false);
            }

            @Override
            public void onFinished() {
                super.onFinished();
                mSwipeLayout.setRefreshing(false);
            }
        });


    }
}
