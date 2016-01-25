package com.liuzhao.onroad.adapter;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.entity.Article;

import java.util.List;


public class StoryListAdapter extends BaseListAdapter<Article> {

    public StoryListAdapter(Context context, List<Article> values) {
        super(context, values);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected View getItemView(View convertView, int position) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_travel, null);
        }
        ImageView iv_head = ViewHolder.get(convertView, R.id.iv_head);
        return convertView;
    }

}
