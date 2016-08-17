package com.liuzhao.onroad.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.widget.Toast;

import com.liuzhao.onroad.activity.RoadApp;

import org.xutils.common.util.LogUtil;

import java.io.File;
import java.util.ArrayList;


public class Utils {
    /**
     * @athor lz 显示toast
     * @dateTime 2016/3/10 9:21
     */
    public static void showMyToast(String content) {
        if (!StringUtils.isNullOrEmpty(content)) {
            if (RoadApp.getSelf().getBuilder() != null) {
                RoadApp.getSelf().getBuilder().display(content, Toast.LENGTH_SHORT);
            }
        }
    }

    /**
     * @athor lz 判断网络是否可用
     * @dateTime 2016/3/10 9:21
     */
    public static boolean isNetworkAvailable(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //分享文字，调用系统的
    public static void shareText(String shareText, Context mContext) {
        if (shareText == null) {
            return;
        }
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        shareIntent.setType("text/plain");

        //设置分享列表的标题，并且每次都显示分享列表
        mContext.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    //分享单张图片
    public static void shareSingleImage(String imagePath, Context mContext) {
        if (imagePath == null) {
            return;
        }
        //由文件得到uri
        Uri imageUri = Uri.fromFile(new File(imagePath));
        LogUtil.d("share+uri:" + imageUri);

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/*");
        mContext.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    //分享多张图片
    public static void shareMultipleImage(ArrayList uriList, Context mContext) {

//        String path = Environment.getExternalStorageDirectory() + File.separator;
//        uriList.add(Uri.fromFile(new File(path+"australia_1.jpg")));
//        uriList.add(Uri.fromFile(new File(path+"australia_2.jpg")));
//        uriList.add(Uri.fromFile(new File(path+"australia_3.jpg")));
        if (uriList == null || uriList.size() == 0) {
            return;
        }
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uriList);
        shareIntent.setType("image/*");
        mContext.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }
}
