package com.liuzhao.onroad.util;

import android.widget.Toast;

import com.liuzhao.onroad.activity.RoadApp;


public class Utils {

    public static void showToast(String content) {
        if (!StringUtils.isNullOrEmpty(content)) {

            if (RoadApp.getSelf().getBuilder() != null) {
                RoadApp.getSelf().getBuilder().display(content, Toast.LENGTH_SHORT);
            }
        }

    }
}
