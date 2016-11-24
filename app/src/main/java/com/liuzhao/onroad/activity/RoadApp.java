package com.liuzhao.onroad.activity;

import android.app.Application;

import com.liuzhao.onroad.common.CommonConstants;
import com.liuzhao.onroad.common.SharePreferenceContants;
import com.liuzhao.onroad.entity.UserInfo;
import com.liuzhao.onroad.net.Apn;
import com.liuzhao.onroad.util.SharePreferenceUtil;
import com.liuzhao.onroad.view.ToastMgr;
import com.umeng.socialize.PlatformConfig;

import org.xutils.x;

public class RoadApp extends Application implements SharePreferenceContants {

    /**
     * 保存当前Application实例，用于方便调用当前应用的全局变量
     */
    private static RoadApp mApp;

    public static RoadApp getSelf() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        x.Ext.init(this);
        x.Ext.setDebug(CommonConstants.DEBUG); // 是否输出debug日志
        Apn.init();
        getBuilder().init(mApp);
        //微信 appid appsecret
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        // QQ和Qzone appid appkey
        PlatformConfig.setAlipay("2015111700822536");
    }

    public RoadApp() {
        /* 当前应用对像初始化 */
        mApp = this;
    }

    // 通用提示toast
    public ToastMgr getBuilder() {
        return ToastMgr.builder;

    }

    /**
     * 保存用户信息
     *
     * @param result
     * @param saveToken 是否要添加token，用于登录后的保存
     */
    public void saveUserInfo(UserInfo result, boolean saveToken) {
        // 记录token信息
        if (saveToken) {
            SharePreferenceUtil.USER.setString(USER_INFO.USER_TOKEN,
                    result.getToken());
        }
        // 记录用户其他必要信息
        SharePreferenceUtil.USER.setString(USER_INFO.LOGIN_NAME,
                result.getName());
        SharePreferenceUtil.USER.setString(USER_INFO.USER_PHONE,
                result.getMobile());
        SharePreferenceUtil.USER.setString(USER_INFO.USER_HEADER_PIC,
                result.getHeadPic());
        SharePreferenceUtil.USER.setInt(USER_INFO.USER_SEX, result.getSex());
        SharePreferenceUtil.USER.setInt(USER_INFO.USER_ID, result.getUserId());
    }

    /**
     * 清空用户信息,用于登出
     */
    public void clearUserInfo() {
        // 记录用户其他必要信息
        SharePreferenceUtil.USER.deleteString(USER_INFO.LOGIN_NAME);
        // 增加了记住手机号功能，手机号在登出时不清空
        // SharePreferenceUtil.USER.deleteString(USER_INFO.USER_PHONE);
        SharePreferenceUtil.USER.deleteString(USER_INFO.USER_HEADER_PIC);
        SharePreferenceUtil.USER.deleteString(USER_INFO.USER_SEX);
        SharePreferenceUtil.USER.deleteString(USER_INFO.USER_ID);
    }

    public void clearAddressInfo() {
        SharePreferenceUtil.COMMON.deleteString(COMMON_INFO.LONGITUDE);
        SharePreferenceUtil.COMMON.deleteString(COMMON_INFO.LATITUDE);
        SharePreferenceUtil.COMMON.deleteString(COMMON_INFO.ADDRESS);
    }

}
