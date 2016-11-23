package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.adapter.RvAdapter;
import com.liuzhao.onroad.entity.Article;
import com.liuzhao.onroad.view.RecyclerViewHeader;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhao
 * @date 2015-12-8下午3:37:46
 */
@ContentView(R.layout.fragment_message)
public class MessageFragment extends BaseFragment {
    private List<Article> list;
    @ViewInject(R.id.header)
    private RecyclerViewHeader mRecyclerHeader;
    @ViewInject(R.id.recycler)
    private RecyclerView mRecycler;
    private RvAdapter rvAdapter;


    public static final MessageFragment getInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        list = new ArrayList<Article>();
        for (int i = 0; i < 10; i++) {
            Article result = new Article();
            result.setAuthor("作者");
            list.add(result);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView() {
        // 创建一个线性布局管理器
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        // 创建矩形布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        // 设置布局管理器
        mRecycler.setLayoutManager(layoutManager);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("num" + i);
        }
        rvAdapter = new RvAdapter(getActivity(), list);
        mRecycler.setAdapter(rvAdapter);
        mRecyclerHeader.attachTo(mRecycler, true);
        // 设置item动画
        mRecycler.setItemAnimator(new DefaultItemAnimator());
    }
}
