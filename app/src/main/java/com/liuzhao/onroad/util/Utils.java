package com.liuzhao.onroad.util;

import android.widget.Toast;

import com.liuzhao.onroad.activity.RoadApp;
import com.liuzhao.onroad.view.ToastMgr;


public class Utils {

	public static void showToast(String content) {
		if (!StringUtils.isNullOrEmpty(content)) {
			ToastMgr.builder.init(RoadApp.getSelf());
			ToastMgr.builder.display(content, Toast.LENGTH_SHORT);
		}

	}
}
