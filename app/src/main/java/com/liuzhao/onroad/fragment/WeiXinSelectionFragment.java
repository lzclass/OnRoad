package com.liuzhao.onroad.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.activity.MainActivity;
import com.liuzhao.onroad.adapter.WeiXinSelectionAdapter;
import com.liuzhao.onroad.entity.WeiXinSelection;
import com.liuzhao.onroad.view.listview.XListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by liuzhao on 2015/12/17.
 */
@ContentView(R.layout.fragment_main)
public class WeiXinSelectionFragment extends BaseFragment {

    @ViewInject(R.id.section_label)
    private TextView section_label;
    @ViewInject(R.id.xlv_content)
    private XListView xlv_content;
    private WeiXinSelectionAdapter adapter;
    private List<WeiXinSelection> list;
    private static final String ARG_SECTION_NUMBER = "section_number";

    public WeiXinSelectionFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static WeiXinSelectionFragment newInstance(int sectionNumber) {
        WeiXinSelectionFragment fragment = new WeiXinSelectionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i=0;i<10;i++){
            WeiXinSelection weiXinSelection = new WeiXinSelection();
            weiXinSelection.setSource("静默山水间");
            weiXinSelection.setTitle("空谷幽兰");
            weiXinSelection.setFirstImg("http://pic2.ooopic.com/01/03/51/25b1OOOPIC19.jpg");
        }
        adapter = new WeiXinSelectionAdapter(getActivity(), list);
        xlv_content.setAdapter(adapter);
        Bundle args = new Bundle();
        section_label.setText("内容" + args.getInt(ARG_SECTION_NUMBER));
        xlv_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
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
