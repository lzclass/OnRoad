package com.liuzhao.onroad.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import org.xutils.x;

/**
 * SharePreference工具类
 */
public enum SharePreferenceUtil {
	/** 存储用户相关信息 */
	USER(x.app(), "user"),
	/** 存储一般信息 */
	COMMON(x.app(), "common");
	private SharedPreferences sharedPreferences;
	private Context context;
	private String share_name;

	private SharePreferenceUtil(Context context, String share_name) {
		this.context = context;
		this.share_name = share_name;
		getSharedPreferences();
	}

	public SharedPreferences getSharedPreferences() {
		sharedPreferences = context.getSharedPreferences(share_name,
				Context.MODE_PRIVATE);
		return sharedPreferences;
	}

	public void setString(String key, String value) {
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public String getString(String key, String defaultvaule) {
		String value = sharedPreferences.getString(key, defaultvaule);
		return value;
	}

	public void deleteString(String key) {
		Editor editor = sharedPreferences.edit();
		editor.remove(key);
		editor.commit();
	}

	public void setBoolean(String key, Boolean value) {
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public Boolean getBoolean(String key, Boolean defaultvalue) {
		Boolean value = sharedPreferences.getBoolean(key, defaultvalue);
		return value;
	}

	public void setInt(String key, int value) {
		Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public int getInt(String key, int defaultvalue) {
		int value = sharedPreferences.getInt(key, defaultvalue);
		return value;
	}

	public void setFloat(String key, float value) {
		Editor editor = sharedPreferences.edit();
		editor.putFloat(key, value);
		editor.commit();
	}

	public float getFloat(String key, float defaultvalue) {
		float value = sharedPreferences.getFloat(key, defaultvalue);
		return value;
	}

	public void setLong(String key, long value) {
		Editor editor = sharedPreferences.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	public long getLong(String key, long defaultvalue) {
		long value = sharedPreferences.getLong(key, defaultvalue);
		return value;
	}

}
