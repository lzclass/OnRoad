package com.liuzhao.onroad.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.entity.WeiXinSelection;

import org.xutils.x;

import java.util.List;

/**
 * Created by liuzhao on 2016/3/8.
 */
public class WeiXinSelectionAdapter extends BaseListAdapter<WeiXinSelection> {
    public WeiXinSelectionAdapter(Context context, List<WeiXinSelection> values) {
        super(context, values);
    }

    @Override
    protected View getItemView(View convertView, int position) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_weixin_selection, null);
        }
        ImageView iv_firstImg = ViewHolder.get(convertView, R.id.iv_firstImg);
        TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);
        x.image().bind(iv_firstImg, mValues.get(position).getFirstImg());
        tv_title.setText(mValues.get(position).getTitle());
        return convertView;
    }
}
