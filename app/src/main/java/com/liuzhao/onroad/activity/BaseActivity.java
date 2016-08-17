package com.liuzhao.onroad.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liuzhao.onroad.BuildConfig;

import org.xutils.x;


/**
 * @author liuzhao on 2015-9-5下午8:20:27 邮箱：63993048@qq.com activity基础类
 */
public class BaseActivity extends AppCompatActivity {

    public RoadApp mApp;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        x.view().inject(this);
        x.Ext.init(mApp);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
        mApp = RoadApp.getSelf();
    }

}
