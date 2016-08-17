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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.fragment.HomePageFragment;
import com.liuzhao.onroad.fragment.JokeFragment;
import com.liuzhao.onroad.fragment.PictureInfoFragment;
import com.liuzhao.onroad.util.Utils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
@ContentView(value = R.layout.activity_main)
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{
    private View nav_header_main;
    private ImageView iv_headImage;
    private TextView tv_username;
    @ViewInject(value = R.id.nav_view)
    private NavigationView nav_view;
    private LinearLayout ll_head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll_head= (LinearLayout) nav_view.getHeaderView(0).findViewById(R.id.ll_head);
        iv_headImage= (ImageView)nav_view.getHeaderView(0).findViewById(R.id.iv_headImage);
        tv_username= (TextView) nav_view.getHeaderView(0).findViewById(R.id.tv_username);
        ll_head.setOnClickListener(this);
        nav_view.setNavigationItemSelectedListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        tv_username.setText("静默山水间");
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_head:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
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
        // Inflate the menu; this adds items to the action bar if it is present.
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
        switch (item.getItemId()) {
            case R.id.nav_home:
                fragmentTransaction.replace(R.id.fra_layout, HomePageFragment.getInstance()).commit();
                break;
            case R.id.nav_text:
                fragmentTransaction.replace(R.id.fra_layout, JokeFragment.getInstance()).commit();
                break;
            case R.id.nav_picture:
                fragmentTransaction.replace(R.id.fra_layout, PictureInfoFragment.getInstance()).commit();
                break;
            case R.id.nav_audio:
                fragmentTransaction.replace(R.id.fra_layout, HomePageFragment.getInstance()).commit();
                break;
            case R.id.nav_video:
                fragmentTransaction.replace(R.id.fra_layout, HomePageFragment.getInstance()).commit();
                break;
            case R.id.nav_send:
                Utils.showMyToast("跳转到反馈页");
                break;
            case R.id.nav_share:
                Utils.showMyToast("跳转到分享页面");
                break;

        }
//        item.setChecked(true);
        //关闭左边菜单
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    public void restoreActionBar() {
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//        actionBar.setDisplayShowTitleEnabled(true);
//        actionBar.setTitle(mTitle);
//    }


}
