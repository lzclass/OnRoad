package com.liuzhao.onroad.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.adapter.StoryListAdapter;
import com.liuzhao.onroad.entity.Article;
import com.liuzhao.onroad.view.RecyclerViewHeader;

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
    private List<Article> list;
    @ViewInject(R.id.header)
    private RecyclerViewHeader mRecyclerHeader;
    @ViewInject(R.id.recycler)
    private RecyclerView mRecycler;


    public static final StoryFragment newInstance() {
        StoryFragment fragment = new StoryFragment();
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

        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(new StoryListAdapter(getActivity(), 10));

        mRecyclerHeader.attachTo(mRecycler, true);
    }
}
