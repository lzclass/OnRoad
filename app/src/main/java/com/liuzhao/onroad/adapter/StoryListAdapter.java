package com.liuzhao.onroad.adapter;


import android.content.Context;
import android.view.View;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.entity.StoryListResult;

import java.util.List;


public class StoryListAdapter extends BaseListAdapter<StoryListResult> {

	public StoryListAdapter(Context context, List<StoryListResult> values) {
		super(context, values);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected View getItemView(View convertView, int position) {
		convertView = mInflater.inflate(R.layout.adapter_travel, null);
		return convertView;
	}

}
