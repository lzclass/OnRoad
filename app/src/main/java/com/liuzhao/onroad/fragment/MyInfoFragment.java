package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.liuzhao.onroad.R;

import org.xutils.view.annotation.ContentView;


/**
 * @author liuzhao on 2015-9-22下午4:51:45 邮箱：63993048@qq.com 个人信息
 */
@ContentView(R.layout.fragment_my_info)
public class MyInfoFragment extends BaseFragment {

    private RecyclerView rv_menu;

    public static final MyInfoFragment getInstance() {
        MyInfoFragment fragment = new MyInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
