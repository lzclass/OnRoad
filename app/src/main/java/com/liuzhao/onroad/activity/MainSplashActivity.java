package com.liuzhao.onroad.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.common.SharePreferenceContants;
import com.liuzhao.onroad.util.SharePreferenceUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.lang.ref.WeakReference;

public class MainSplashActivity extends BaseActivity {

    private static final int ANIMATION_END_MSG = 1;
    private boolean isBack = false;
    /**
     * logo图标
     */
    @ViewInject(R.id.ll_launcher)
    private LinearLayout ll_launcher;

    private static MyHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 防止应用在安装时多次重复启动
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        setContentView(R.layout.activity_main_splash);
        x.view().inject(this);
        initData();
    }

    private void initData() {
        if (Integer.parseInt(Build.VERSION.SDK) < Build.VERSION_CODES.FROYO) {
            System.setProperty("http.keepAlive", "false");
        }
        handler = new MyHandler(this);
        // 确认是否显示引导页
        Animation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(2500);
        animation.setAnimationListener(mAnimationListener);
        ll_launcher.startAnimation(animation);
    }

    @Override
    public void onBackPressed() {
        isBack = true;
    }

    private void addShortCut() {
        Intent shortcut = new Intent(
                "com.android.launcher.action.INSTALL_SHORTCUT");
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME,
                getString(R.string.app_name));
        shortcut.putExtra("duplicate", false);
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(
                this, R.drawable.ic_drawer);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
        Intent respondIntent = new Intent(this, this.getClass());
        respondIntent.setAction(Intent.ACTION_MAIN);
        respondIntent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        respondIntent.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        respondIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, respondIntent);
        sendBroadcast(shortcut);
        SharePreferenceUtil.USER.setBoolean(SharePreferenceContants.COMMON_INFO.APP_SHORT_CUT, true);
    }

    private boolean IfaddShortCut() {
        boolean isInstallShortcut = false;
        final ContentResolver cr = this.getContentResolver();
        String AUTHORITY = "";
        AUTHORITY = "com.android.launcher.settings";

        final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
                + "/favorites?notify=true");
        Cursor c = cr.query(CONTENT_URI,
                new String[]{"title", "iconResource"}, "title=?",
                new String[]{getString(R.string.app_name)}, null);
        if (c != null && c.getCount() > 0) {
            AUTHORITY = "com.android.launcher2.settings";
            final Uri CONTENT_URIS = Uri.parse("content://" + AUTHORITY
                    + "/favorites?notify=true");
            Cursor cs = cr.query(CONTENT_URIS, new String[]{"title",
                            "iconResource"}, "title=?",
                    new String[]{getString(R.string.app_name)}, null);
            if (cs != null && cs.getCount() > 0) {
                isInstallShortcut = true;
            }
        }
        return isInstallShortcut;
    }

    /**
     * 动画监听事件
     */
    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {

            if (!SharePreferenceUtil.COMMON.getBoolean(
                    SharePreferenceContants.COMMON_INFO.APP_SHORT_CUT, false)) {
                if (IfaddShortCut() == false) {
                    addShortCut();
                }
            }
            if (!isBack) {
                handler.obtainMessage(ANIMATION_END_MSG).sendToTarget();
            }
        }
    };

    private static class MyHandler extends Handler {
        WeakReference<MainSplashActivity> ref;

        public MyHandler(MainSplashActivity activity) {
            ref = new WeakReference<MainSplashActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ANIMATION_END_MSG:
                    Intent intent = new Intent();
                    // 根据登陆的token来判断进入哪个页面
                    if (SharePreferenceUtil.USER.getString(SharePreferenceContants.USER_INFO.USER_TOKEN,
                            SharePreferenceContants.USER_INFO.VALUE_NO_LOGIN).equals(
                            SharePreferenceContants.USER_INFO.VALUE_NO_LOGIN)) {
                        // 没有token，进入登陆页面
                        intent.setClass(ref.get(), LoginActivity.class);
                    } else {
                        // 有token，进入主界面
                        intent.setClass(ref.get(), MainActivity.class);
                    }
                    ref.get().startActivity(intent);
                    ref.get().finish();
                    break;
                default:
                    break;
            }
        }
    }

}
