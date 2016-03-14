package com.liuzhao.onroad.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.entity.JokeBean;
import com.liuzhao.onroad.util.Utils;

import java.util.List;

/**
 * Created by liuzhao on 2016/3/1.
 */
public class JokeListAdapter extends BaseListAdapter<JokeBean> {
    public JokeListAdapter(Context context, List<JokeBean> values) {
        super(context, values);
    }

    @Override
    protected View getItemView(View convertView, final int position) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_joke_list, null);
        }
        TextView tv_content = ViewHolder.get(convertView, R.id.tv_content);
        TextView tv_datetime = ViewHolder.get(convertView, R.id.tv_datetime);
        TextView tv_share = ViewHolder.get(convertView, R.id.tv_share);
        tv_content.setText(mValues.get(position).getContent());
        tv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.shareText(mValues.get(position).getContent(), mContext);
            }
        });
        return convertView;
    }
}
