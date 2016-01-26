package com.liuzhao.onroad.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.activity.MainActivity;
import com.liuzhao.onroad.adapter.TravelListAdapter;
import com.liuzhao.onroad.entity.Article;
import com.liuzhao.onroad.view.listview.XListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by liuzhao on 2015/12/17.
 */
@ContentView(R.layout.fragment_main)
public class PlaceholderFragment extends BaseFragment {

    @ViewInject(R.id.section_label)
    private TextView section_label;
    @ViewInject(R.id.xlv_content)
    private XListView xlv_content;
    private TravelListAdapter adapter;
    private List<Article> list;
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i=0;i<10;i++){
            Article article = new Article();
            article.setAuthor("静默山水间");
            article.setTitle("空谷幽兰");
            article.setHeadPic("http://pic2.ooopic.com/01/03/51/25b1OOOPIC19.jpg");
        }
        adapter = new TravelListAdapter(getActivity(), list);
        xlv_content.setAdapter(adapter);
        Bundle args = new Bundle();
        section_label.setText("内容" + args.getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
