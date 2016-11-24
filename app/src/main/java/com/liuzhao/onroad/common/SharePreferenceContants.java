package com.liuzhao.onroad.common;

/**
 * Created by liuzhao on 2016/1/25.
 */
public interface SharePreferenceContants {
    /**
     * @description 用于USER的key
     */
    interface USER_INFO {
        String USER_TOKEN = "access_token";// 用户token,String型
        String LOGIN_NAME = "loginName";// 用户名，String型
        String NICK_NAME = "nickName";// 昵称，String型
        String USER_PHONE = "userMobile";// 用户手机号，String型
        String USER_HEADER_PIC = "userHeaderPic";// 用户头像，String型
        String USER_SEX = "sex";// 用户性别，int型
        String USER_ID = "user_id";// 用户id,int型
    }

    /**
     * @description 用于Common的key
     */
    interface COMMON_INFO {
        String USER_FIRST_ENTER = "firstEnter";// 用户是否第一次进入，boolean型
        String APP_VERSION = "version";// 应用当前版本
        String APP_SHORT_CUT = "has_shortcut";// lanuncher是否有应用图标，boolean型
        String LONGITUDE = "longitude";// 经度坐标,double值
        String LATITUDE = "latitude";// 纬度坐标，double值
        String ADDRESS = "address";//坐标相对应的地址名称，String值
    }
}
