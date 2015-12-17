package com.liuzhao.onroad.activity;

import org.xutils.x;

import android.app.Application;

public class RoadApp extends Application {

	/** 保存当前Application实例，用于方便调用当前应用的全局变量 */
	private static RoadApp mApp;
	public static RoadApp getSelf() {
		return mApp;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		x.Ext.init(this);
		x.Ext.setDebug(true); // 是否输出debug日志
	}

	public RoadApp() {
		/* 当前应用对像初始化 */
		mApp = this;
	}


}
