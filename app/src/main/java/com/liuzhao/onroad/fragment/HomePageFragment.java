package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuzhao.onroad.R;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.fragment_home_page)
public class HomePageFragment extends BaseFragment {
    @ViewInject(R.id.iv_content)
    private ImageView iv_content;
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

    public HomePageFragment() {
        // Required empty public constructor
    }


    public static HomePageFragment newInstance() {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initDate() {
        x.image().bind(iv_content,"http://img.taopic.com/uploads/allimg/130529/240454-13052ZR31446.jpg",ImageOptions.DEFAULT);
    }

}
