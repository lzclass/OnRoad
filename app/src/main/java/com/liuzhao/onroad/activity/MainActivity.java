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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.fragment.HomePageFragment;
import com.liuzhao.onroad.fragment.JokeFragment;
import com.liuzhao.onroad.fragment.PictureInfoFragment;
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
    private LinearLayout ll_head;
    private Button btn_sign;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
        initView();

    }
    private void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("首页");//setTitle方法要在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }
    private void initView(){
        ll_head = (LinearLayout) nav_view.getHeaderView(0).findViewById(R.id.ll_head);
        iv_headImage = (ImageView) nav_view.getHeaderView(0).findViewById(R.id.iv_headImage);
        tv_username = (TextView) nav_view.getHeaderView(0).findViewById(R.id.tv_username);
        btn_sign = (Button) nav_view.getHeaderView(0).findViewById(R.id.btn_sign);
        ll_head.setOnClickListener(this);
        btn_sign.setOnClickListener(this);
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
                .setSize(100, 100)
                .setIgnoreGif(false)
                .setImageScaleType(ImageView.ScaleType.MATRIX)
                .build();
        x.image().bind(iv_headImage, "http://pic.4j4j.cn/upload/pic/20130815/31e652fe2d.jpg", imageOptions);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_head:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.btn_sign:
                Utils.showMyToast("签到+1");
                btn_sign.setText("已签到");
                btn_sign.setEnabled(false);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
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
                break;
            case R.id.nav_fo:
                fragmentTransaction.replace(R.id.fra_layout, JokeFragment.getInstance()).commit();
                break;
            case R.id.nav_dao:
                fragmentTransaction.replace(R.id.fra_layout, PictureInfoFragment.getInstance()).commit();
                break;
            case R.id.nav_ru:
                fragmentTransaction.replace(R.id.fra_layout, HomePageFragment.getInstance()).commit();
                break;
            case R.id.nav_send:
                Utils.showMyToast("跳转到反馈页");
                break;
            case R.id.nav_share:
                Utils.showMyToast("跳转到分享页面");
                break;

        }
        //关闭左边菜单
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
