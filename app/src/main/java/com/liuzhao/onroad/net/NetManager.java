package com.liuzhao.onroad.net;


import org.xutils.common.Callback;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import javax.net.ssl.SSLSocketFactory;

/**
 * @author liuzhao
 * @description 网络请求
 * @date 2015-11-27上午10:49:57
 */
public enum NetManager {
    INSTANCE;

    private NetManager() {

    }

    private static void buildParams(RequestParams params) {

    }

    public static void doGetHttp(RequestParams params, NetCommonCallback netCommonCallback)

    {
        buildParams(params);
        params = new RequestParams("https://www.baidu.com/s");

//      params.setSslSocketFactory(); // 设置ssl
        params.addQueryStringParameter("wd", "xUtils");
        x.http().get(params, netCommonCallback);
    }

    public abstract class NetCommonCallback implements CommonCallback<String> {

        @Override
        public void onSuccess(String result) {
            LogUtil.d(result);
        }

        @Override
        public void onError(Throwable throwable, boolean isOnCallback) {
            LogUtil.d(throwable.getMessage());
        }

        @Override
        public void onCancelled(CancelledException e) {
            LogUtil.e("onCancelled" + e.getMessage());
        }

        @Override
        public void onFinished() {

        }
    }
}
