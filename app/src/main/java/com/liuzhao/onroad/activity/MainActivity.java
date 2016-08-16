package com.liuzhao.onroad.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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
import android.widget.TextView;
import android.widget.Toast;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.fragment.HomePageFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @ViewInject(value = R.id.iv_headImage)
    private ImageView iv_headImage;
    @ViewInject(value = R.id.tv_username)
    private TextView tv_username;
    @ViewInject(value = R.id.nav_view)
    private NavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

//        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);
        initFragment();
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = HomePageFragment.newInstance();
        fragmentTransaction.add(R.id.fra_layout, fragment);
        fragmentTransaction.commit();
    }

    @Event(type = View.OnClickListener.class, value = R.id.iv_headImage)
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_headImage:
                Toast.makeText(this, "你好我是Xutils的IOC功能", Toast.LENGTH_SHORT).show();
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:

                break;
            case R.id.nav_text:

                break;
            case R.id.nav_picture:

                break;
            case R.id.nav_audio:

                break;
            case R.id.nav_video:

                break;
            case R.id.nav_send:

                break;
            case R.id.nav_share:

                break;

        }
        //关闭左边菜单
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//
//    @Override
//    public void onNavigationDrawerItemSelected(int position) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        switch (position) {
//            case 0:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, HomePageFragment.newInstance())
//                        .commit();
//                break;
//            case 1:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, JokeFragment.newInstance())
//                        .commit();
//                break;
//            case 2:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, StoryFragment.newInstance())
//                        .commit();
//                break;
//            case 3:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, PictureFragment.newInstance())
//                        .commit();
//                break;
//
//        }
//
//    }
//
//    public void onSectionAttached(int number) {
//        switch (number) {
//            case 0:
//                mTitle = getString(R.string.home_page);
//                break;
//            case 1:
//                mTitle = getString(R.string.title_section1);
//                break;
//            case 2:
//                mTitle = getString(R.string.title_section2);
//                break;
//            case 3:
//                mTitle = getString(R.string.title_section3);
//                break;
//        }
//    }

//    public void restoreActionBar() {
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//        actionBar.setDisplayShowTitleEnabled(true);
//        actionBar.setTitle(mTitle);
//    }


}
