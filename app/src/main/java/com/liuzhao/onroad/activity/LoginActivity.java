package com.liuzhao.onroad.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.liuzhao.onroad.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.Map;

@ContentView(value = R.layout.activity_login)
public class LoginActivity extends BaseActivity {
    private UMShareAPI mShareAPI;
    private SHARE_MEDIA platform = SHARE_MEDIA.SINA;
    @ViewInject(value = R.id.iv_qq)
    private ImageView iv_qq;
    @ViewInject(value = R.id.iv_weixin)
    private ImageView iv_weixin;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        mShareAPI = UMShareAPI.get(this);
        mShareAPI.doOauthVerify(this, platform, umAuthListener);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("登录");//setTitle方法要在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(toolbar);
    }

    @Event(type = View.OnClickListener.class,value = {R.id.iv_qq, R.id.iv_weixin} )
    private void onButtonClick(View v) {
        switch (v.getId()) {
            case R.id.iv_qq:

                break;
            case R.id.iv_weixin:

                break;
        }
    }


    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }

}

