package com.liuzhao.onroad.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.activity.BaseActivity;
import com.liuzhao.onroad.activity.RoadApp;
import com.liuzhao.onroad.entity.DayWordData;
import com.liuzhao.onroad.entity.DayWordResult;
import com.liuzhao.onroad.net.NetCommonCallback;
import com.liuzhao.onroad.net.NetConstants;
import com.liuzhao.onroad.net.NetManager;
import com.liuzhao.onroad.util.DateUtils;
import com.liuzhao.onroad.util.JsonUtils;

import org.xutils.common.Callback;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;

@ContentView(R.layout.fragment_home_page)
public class HomePageFragment extends BaseFragment {
    @ViewInject(R.id.iv_home_content)
    private ImageView iv_home_content;
    @ViewInject(R.id.tv_pic_no)
    private TextView tv_pic_no;
    @ViewInject(R.id.tv_pic_author)
    private TextView tv_pic_author;
    @ViewInject(R.id.tv_home_content)
    private TextView tv_home_content;
    @ViewInject(R.id.tv_home_author)
    private TextView tv_home_author;
    @ViewInject(R.id.tv_date)
    private TextView tv_date;
    private String date;

    public HomePageFragment() {
        // Required empty public constructor
    }


    public static HomePageFragment getInstance() {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    private void initDate(DayWordData data) {
        ImageOptions imageOptions = new ImageOptions.Builder()
                // 加载中或错误图片的ScaleType
                //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                // 默认自动适应大小
                // .setSize(...)
                .setIgnoreGif(false)
                .setImageScaleType(ImageView.ScaleType.MATRIX)
                .build();
        tv_pic_no.setText("DALIY_"+DateUtils.formatDate(data.getDateTime()));
        tv_pic_author.setText(data.getAuthor());
        tv_home_content.setText(data.getContent());
        tv_home_author.setText(data.getAuthor());
        tv_date.setText(DateUtils.formatDate(data.getDateTime()));

        x.Ext.init(RoadApp.getSelf());
        x.image().bind(iv_home_content, data.getImageUrl(), new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable drawable) {
                iv_home_content.setImageDrawable(drawable);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }
        });
    }

    private void getData() {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put(NetConstants.METHOD, NetConstants.DAY_WORD);
        NetManager.INSTANCE.doGetHttp(map, new NetCommonCallback(DayWordResult.class, (BaseActivity) getActivity()) {
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                DayWordResult t = JsonUtils.parseJson(result, DayWordResult.class);
                initDate(t.getDatum());
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
