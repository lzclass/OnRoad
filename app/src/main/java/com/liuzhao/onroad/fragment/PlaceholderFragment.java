package com.liuzhao.onroad.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.activity.MainActivity;
import com.liuzhao.onroad.adapter.TravelListAdapter;
import com.liuzhao.onroad.entity.Article;
import com.liuzhao.onroad.view.listview.XListView;

import org.w3c.dom.Text;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhao on 2015/12/17.
 */
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        x.view().inject(getActivity(), rootView);
        list = new ArrayList<Article>();
        adapter = new TravelListAdapter(mActivity, list);
        xlv_content.setAdapter(adapter);
        Bundle args = new Bundle();
        section_label.setText("内容" + args.getInt(ARG_SECTION_NUMBER));
        return rootView;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
