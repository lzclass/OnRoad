package com.liuzhao.onroad.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import com.liuzhao.onroad.activity.RoadApp;
import com.liuzhao.onroad.common.SharePreferenceContants;
import com.liuzhao.onroad.util.SharePreferenceUtil;

import java.util.HashMap;
import java.util.Locale;

/**
 * @author liuzhao on 2015-10-10下午2:43:30 邮箱：63993048@qq.com 服务器网络连接相关设置
 */
public class Apn implements SharePreferenceContants {

    public static final int TYPE_UNKNOWN = 0x000;
    public static final int TYPE_NET = 0x001;
    public static final int TYPE_3G_NET = 0x002;
    public static final int TYPE_WAP = 0x004;
    public static final int TYPE_3G_WAP = 0x003;
    public static final int TYPE_WIFI = 0x005;

    public static final String APN_UNKNOWN = "N/A";
    public static final String APN_NET = "Net";
    public static final String APN_3G_NET = "3GNet";
    public static final String APN_WAP = "Wap";
    public static final String APN_3G_WAP = "3GWap";
    public static final String APN_WIFI = "Wifi";

    /**
     * 连网类型
     */
    public static int M_APN_TYPE = TYPE_WIFI;
    /**
     * 代理地址
     */
    public static String M_APN_PROXY = null;
    /**
     * 代理端口
     */
    public static int M_APN_PORT = 80;
    /**
     * 是否代理
     */
    public static boolean M_USE_PROXY = false;

    // APN 名称
    public static String APN_CMWAP = "cmwap";// 中国移动
    public static String APN_CMNET = "cmnet";
    public static String APN_3GWAP = "3gwap";// 联通接入点
    public static String APN_3GNET = "3gnet";
    public static String APN_UNIWAP = "uniwap";// Unicom Net的缩写,它是中国联通GPRS网络接入点
    public static String APN_UNINET = "uninet";
    public static String APN_CTWAP = "ctwap";// 中国电信
    public static String APN_CTNET = "ctnet";
    /**
     * 渠道号
     */
    public static String APP_COMPANY = "";// 渠道名称
    /**
     * 手机串号
     */
    public static String imei = "";
    /**
     * 手机号码
     */
    public static String phoneNumber = "";
    /**
     * 版本号
     */
    public static String version = "";
    /**
     * 手机系统版本
     */
    public static final String osVersion = android.os.Build.VERSION.RELEASE;
    /**
     * 手机型号
     */
    public static final String model = android.os.Build.MODEL;
    /**
     * 联网方式
     */
    public static String conn_mode = "";
    /**
     * 有无SIM卡
     */
    public static String iscard = "";
    /**
     * 是否定位成功
     */
    public static int ispos = 0;
    /**
     * 压缩方式
     */
    public static final String HTTP_PRESSED_TYPE = "gzip";
    /**
     * 定位城市
     */
    public static String city = "";

    public static HashMap<String, String> addHeads(HashMap<String, String> map) {
        String token = SharePreferenceUtil.USER.getString(USER_INFO.USER_TOKEN,
                "");
        map.put("token", token);// 单点登录唯一识别
        map.put("version", version);// 版本号
        map.put("iMei", imei);// 手机串号
        map.put("model", model);// 手机型号
        map.put("osVersion", osVersion);// 手机系统版本
        map.put("appName", "简单");//app名称
        map.put("phoneNumber", phoneNumber);// 手机号码
        map.put("connMode", conn_mode);// 联网方式
        map.put("city", city);// 城市

        return map;
    }

    /**
     * 初始化网络类型等
     */
    public static void init() {
        Context context = RoadApp.getSelf();
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        try {
            if (tm.getSimState() == TelephonyManager.SIM_STATE_READY) {
                iscard = "1";
            } else {
                iscard = "0";
            }
            imei = tm.getDeviceId();
            phoneNumber = tm.getLine1Number();
            version = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
            int type = -1;
            M_APN_TYPE = TYPE_UNKNOWN;
            String extraInfo = null;
            if (networkInfo != null) {
                type = networkInfo.getType();
                extraInfo = networkInfo.getExtraInfo();
                if (extraInfo == null)
                    M_APN_TYPE = TYPE_UNKNOWN;
                else
                    extraInfo = extraInfo.trim().toLowerCase(
                            Locale.getDefault());
            }

            if (type == ConnectivityManager.TYPE_WIFI) {
                M_APN_TYPE = TYPE_WIFI;
                M_USE_PROXY = false;
            } else {
                if (extraInfo == null) {
                    M_APN_TYPE = TYPE_UNKNOWN;
                } else if (extraInfo.contains(APN_CMWAP)
                        || extraInfo.contains(APN_UNIWAP)
                        || extraInfo.contains(APN_CTWAP)) {
                    M_APN_TYPE = TYPE_WAP;
                } else if (extraInfo.contains(APN_3GWAP)) {
                    M_APN_TYPE = TYPE_3G_WAP;
                } else if (extraInfo.contains(APN_CMNET)
                        || extraInfo.contains(APN_UNINET)
                        || extraInfo.contains(APN_CTNET)) {
                    M_APN_TYPE = TYPE_NET;
                } else if (extraInfo.contains(APN_3GNET)) {
                    M_APN_TYPE = TYPE_3G_NET;
                } else {
                    M_APN_TYPE = TYPE_UNKNOWN;
                }

                M_USE_PROXY = false;
                if (isProxyMode(M_APN_TYPE)) {
                    M_APN_PROXY = android.net.Proxy.getDefaultHost();
                    M_APN_PORT = android.net.Proxy.getDefaultPort();

                    if (M_APN_PROXY != null) {
                        M_APN_PROXY = M_APN_PROXY.trim();
                    }
                    if (M_APN_PROXY != null && !"".equals(M_APN_PROXY)) {
                        M_USE_PROXY = true;
                        M_APN_TYPE = TYPE_WAP;
                    } else {
                        M_USE_PROXY = false;
                        M_APN_TYPE = TYPE_NET;
                    }
                }
            }
            conn_mode = getApnName(M_APN_TYPE);
        } catch (Exception e) {

        }
    }

    private static boolean isProxyMode(int apnType) {
        return apnType == TYPE_WAP || apnType == TYPE_UNKNOWN;
    }

    private static String getApnName(int apnType) {
        switch (apnType) {
            case TYPE_WAP:
                return APN_WAP;
            case TYPE_3G_WAP:
                return APN_3G_WAP;
            case TYPE_NET:
                return APN_NET;
            case TYPE_3G_NET:
                return APN_3G_NET;
            case TYPE_WIFI:
                return APN_WIFI;
            case TYPE_UNKNOWN:
                return APN_UNKNOWN;
            default:
                return APN_UNKNOWN;
        }
    }
}
