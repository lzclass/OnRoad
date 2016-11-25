package com.liuzhao.onroad.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.entity.DayWordData;
import com.liuzhao.onroad.entity.DayWordResult;
import com.liuzhao.onroad.myinterface.NetResultCallBack;
import com.liuzhao.onroad.net.NetCommonCallback;
import com.liuzhao.onroad.net.NetConstants;
import com.liuzhao.onroad.net.NetManager;
import com.liuzhao.onroad.util.DateUtils;
import com.liuzhao.onroad.util.SimpleLunarCalendar;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;

@ContentView(R.layout.fragment_home_page)
public class HomePageFragment extends BaseFragment {
    @ViewInject(R.id.iv_home_content)
    private ImageView iv_home_content;
    @ViewInject(R.id.tv_pic_author)
    private TextView tv_pic_author;
    @ViewInject(R.id.tv_home_content)
    private TextView tv_home_content;
    @ViewInject(R.id.tv_home_author)
    private TextView tv_home_author;
    @ViewInject(R.id.tv_date)
    private TextView tv_date;
    @ViewInject(R.id.tv_LunarDate)
    private TextView tv_LunarDate;


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

    private String getLunarDate(String dateString) {
        SimpleLunarCalendar lunarCalendar = DateUtils.getSimpleLunarCalendar(dateString);
        String lunarDate = "【" + lunarCalendar.getAnimalString() + "年】" + lunarCalendar.getDateString();
        dateString = lunarDate;
        return dateString;
    }

    private void initDate(DayWordData data) {
        tv_pic_author.setText(data.getImageAuthor()+" 作品");
        tv_home_content.setText(data.getContent());
        tv_home_author.setText("by " + data.getTextAuthor());
        tv_date.setText(data.getDateTime().replace("-", ".") +" "+ DateUtils.DateToWeek(DateUtils.StringToDate(data.getDateTime())));
        tv_LunarDate.setText(getLunarDate(data.getDateTime()));

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
        map.put(NetConstants.METHOD, NetConstants.GET_DAY_WORD);
        NetManager.INSTANCE.doGetHttp(map, new NetCommonCallback(DayWordResult.class, mContext, new NetResultCallBack<DayWordResult>() {
            @Override
            public void onSuccess(DayWordResult result) {
                initDate(result.getDatum());
            }

            @Override
            public void onError(int code, String msg) {

            }
        }));


    }
}
