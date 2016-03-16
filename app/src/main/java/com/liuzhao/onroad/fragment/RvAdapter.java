package com.liuzhao.onroad.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuzhao.onroad.R;

import java.util.List;

/**
 * Created by liuzhao on 2016/3/16.
 */
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> list;

    public RvAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public RvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.adapter_rv, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RvAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
        }
    }
}
