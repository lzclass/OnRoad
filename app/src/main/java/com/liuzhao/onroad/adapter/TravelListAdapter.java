package com.liuzhao.onroad.adapter;

import android.content.Context;
import android.view.View;
import com.liuzhao.onroad.R;

import java.util.List;


public class TravelListAdapter extends BaseListAdapter<String> {

	public TravelListAdapter(Context context, List<String> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_travel, null);
		}

		return convertView;
	}

}
