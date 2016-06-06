package com.liuzhao.onroad.activity;

import android.os.Bundle;
import android.view.View;

import com.liuzhao.onroad.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);

    }

    @Event(value = R.id.btn_login, type = View.OnClickListener.class)
    private void onButtonClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                break;
        }
    }
}

