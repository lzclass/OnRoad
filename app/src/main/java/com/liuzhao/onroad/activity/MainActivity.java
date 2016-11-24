package com.liuzhao.onroad.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.fragment.FavoriteFragment;
import com.liuzhao.onroad.fragment.HomePageFragment;
import com.liuzhao.onroad.fragment.MessageFragment;
import com.liuzhao.onroad.fragment.TopicFragment;
import com.liuzhao.onroad.util.Utils;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private View nav_header_main;
    private ImageView iv_headImage;
    private TextView tv_username;
    @ViewInject(value = R.id.nav_view)
    private NavigationView nav_view;
    private RelativeLayout rl_head;
    private Toolbar toolbar;
    private int selected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
        initView();

    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("首页");//setTitle方法要在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initView() {
        rl_head = (RelativeLayout) nav_view.getHeaderView(0).findViewById(R.id.rl_head);
        iv_headImage = (ImageView) nav_view.getHeaderView(0).findViewById(R.id.iv_headImage);
        tv_username = (TextView) nav_view.getHeaderView(0).findViewById(R.id.tv_username);
        rl_head.setOnClickListener(this);
        nav_view.setNavigationItemSelectedListener(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tv_username.setText("静默山水间");
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setCircular(true)
                // 加载中或错误图片的ScaleType
                .setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                // 不设置则默认自动适应大小
                .setSize(150, 150)
                .setIgnoreGif(false)
                .setImageScaleType(ImageView.ScaleType.MATRIX)
                .build();
        x.image().bind(iv_headImage, "http://pic.4j4j.cn/upload/pic/20130815/31e652fe2d.jpg", imageOptions);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_username:
                if (tv_username.getText().toString().equals("未登录")) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 头部标题右侧
        if (selected == 0) {
            getMenuInflater().inflate(R.menu.main, menu);
        } else if (selected == 1){
            getMenuInflater().inflate(R.menu.topic, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Utils.showMyToast("分享");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        toolbar.setTitle(item.getTitle());
        switch (item.getItemId()) {
            case R.id.nav_home:
                fragmentTransaction.replace(R.id.fra_layout, HomePageFragment.getInstance()).commit();
                selected = 0;
                break;
            case R.id.nav_topic:
                fragmentTransaction.replace(R.id.fra_layout, TopicFragment.getInstance()).commit();
                selected = 1;
                break;
            case R.id.nav_favorite:
                fragmentTransaction.replace(R.id.fra_layout, FavoriteFragment.newInstance()).commit();
                selected = 2;
                break;
            case R.id.nav_message:
                fragmentTransaction.replace(R.id.fra_layout, MessageFragment.getInstance()).commit();
                selected = 3;
                break;
            case R.id.nav_send:
                Utils.showMyToast("跳转到反馈页");
                break;
            case R.id.nav_share:
                Utils.showMyToast("跳转到分享页面");
                break;

        }
        MainActivity.this.invalidateOptionsMenu();
        //关闭左边菜单
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
