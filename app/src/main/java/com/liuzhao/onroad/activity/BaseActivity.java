package com.liuzhao.onroad.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liuzhao.onroad.util.Utils;

import org.xutils.x;


/**
 * @author liuzhao on 2015-9-5下午8:20:27 邮箱：63993048@qq.com activity基础类
 */
public class BaseActivity extends AppCompatActivity {
    public static void toast(String strMsg) {
        Utils.showToast(strMsg);
    }

    public RoadApp mApp;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        x.view().inject(this);
        mApp = RoadApp.getSelf();
    }

}
