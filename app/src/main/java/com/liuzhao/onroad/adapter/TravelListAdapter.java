package com.liuzhao.onroad.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.entity.Article;
import com.liuzhao.onroad.entity.ArticleData;

import org.xutils.x;

import java.util.List;


public class TravelListAdapter extends BaseListAdapter<Article> {

    public TravelListAdapter(Context context, List<Article> values) {
        super(context, values);
    }

    @Override
    protected View getItemView(View convertView, int position) {
        Article model = mValues.get(position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_travel, null);
        }
        ImageView iv_head = ViewHolder.get(convertView, R.id.iv_head);
        x.image().bind(iv_head,model.getHeadPic());
        TextView tv_authorName = ViewHolder.get(convertView,R.id.tv_authorName);
        tv_authorName.setText(model.getAuthor());

        TextView tv_readCount = ViewHolder.get(convertView,R.id.tv_readCount);
        TextView tv_comment = ViewHolder.get(convertView,R.id.tv_comment);
        TextView tv_collect = ViewHolder.get(convertView,R.id.tv_collect);
        TextView tv_supportCount = ViewHolder.get(convertView,R.id.tv_supportCount);


        return convertView;
    }

}
