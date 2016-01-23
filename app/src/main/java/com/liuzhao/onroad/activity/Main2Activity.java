package com.liuzhao.onroad.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.adapter.ViewPagerMainAdapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_main)
public class Main2Activity extends BaseActivity {
    /** 判断跳转到哪个页面的下标 */
    private int tabpos = 0;
    /** Fragment管理类 */
    private FragmentManager fragmentManager;
    @ViewInject(R.id.viewpager)
    private ViewPager mViewPager;
    public final static int TAB_INDEX_1 = 0;
    public final static int TAB_INDEX_2 = 1;
    public final static int TAB_INDEX_3 = 2;
    public final static int TAB_INDEX_4 = 3;
    public final static int TAB_COUNT = 4;
    /** 界面底部的指示圆点容器 */
    @ViewInject(R.id.ll_introduct_index)
    private LinearLayout layout_dotView;
    /** 标题 */
    @ViewInject(R.id.tv_maintitle)
    private TextView tv_maintitle;
    private ImageView[] imgDots = new ImageView[TAB_COUNT];
    private String[] titleStrings={"推荐","话题","写诗"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
		/* fragment事务初始化 */
        fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new ViewPagerMainAdapter(fragmentManager));
        for (int i = 0; i < TAB_COUNT; i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(12, 12);
            lp.leftMargin = 15;
            lp.bottomMargin = 15;
            imageView.setLayoutParams(lp);
            imgDots[i] = imageView;
            if (i == 0) {
                imgDots[i].setBackgroundResource(R.drawable.points_white);
            } else {
                imgDots[i].setBackgroundResource(R.drawable.points_gray);
            }
            layout_dotView.addView(imageView);
        }

		/* 滑动页初始化 */
        mViewPager.setOnPageChangeListener(new MainPagerListener(imgDots));
    }

    public void setTitle(int position) {
        String titleString = "";
        switch (position) {
            case TAB_INDEX_1:
                titleString = "旅行";
                break;
            case TAB_INDEX_2:
                titleString = "故事";
                break;
            case TAB_INDEX_3:
                titleString = "礼物";
                break;
            case TAB_INDEX_4:
                titleString = "我的";
                break;
            default:
                break;
        }
        tv_maintitle.setText(titleString);
    }

    private class MainPagerListener implements OnPageChangeListener {
        private ImageView[] imageViews;

        public MainPagerListener(ImageView[] imgDots) {
            this.imageViews = imgDots;
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            setTitle(arg0);
            mViewPager.setCurrentItem(arg0);
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[arg0].setBackgroundResource(R.drawable.points_gray);
                if (arg0 != i) {
                    imageViews[i]
                            .setBackgroundResource(R.drawable.points_white);
                }
            }
        }
    }
}
