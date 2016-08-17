package com.liuzhao.onroad.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.activity.BaseActivity;
import com.liuzhao.onroad.activity.RoadApp;
import com.liuzhao.onroad.entity.HomePageData;
import com.liuzhao.onroad.entity.HomePageResult;
import com.liuzhao.onroad.net.NetCommonCallback;
import com.liuzhao.onroad.net.NetConstants;
import com.liuzhao.onroad.net.NetManager;
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
        initDate();

    }

    private void initDate() {
        HomePageData data = new HomePageData();
        data.setContent("表，属于时间；钟，属于岁月。是的，它们的区别就是这样，就像一个明喻一个暗喻一样,就像一个散文一个诗一样");
        data.setImgAuthor("行尽天涯");
        data.setDate("02 Feb.2016 Tue");
        data.setTxtAuthor("from 《钟表》");
        data.setImgNo("SIMPLE.20160309");
        data.setImgUrl("http://d.hiphotos.baidu.com/lvpics/w=1000/sign=81bf893e12dfa9ecfd2e521752e0f603/242dd42a2834349b705785a7caea15ce36d3bebb.jpg");
        ImageOptions imageOptions = new ImageOptions.Builder()
                // 加载中或错误图片的ScaleType
                //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                // 默认自动适应大小
                // .setSize(...)
                .setIgnoreGif(false)
                .setImageScaleType(ImageView.ScaleType.MATRIX)
                .build();
        tv_pic_no.setText(data.getImgNo());
        tv_pic_author.setText(data.getImgAuthor());
        tv_home_content.setText(data.getContent());
        tv_home_author.setText(data.getTxtAuthor());
        tv_date.setText(data.getDate());

        x.Ext.init(RoadApp.getSelf());
        x.image().bind(iv_home_content, data.getImgUrl(), new Callback.CommonCallback<Drawable>() {
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
        map.put(NetConstants.METHOD, NetConstants.HOME_PAGE);
        map.put("date", date);
        NetManager.INSTANCE.doGetHttp(map, new NetCommonCallback(HomePageResult.class, (BaseActivity) getActivity()) {
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                HomePageResult t = JsonUtils.parseJson(result, HomePageResult.class);

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
