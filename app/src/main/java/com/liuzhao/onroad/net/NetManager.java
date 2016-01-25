package com.liuzhao.onroad.net;


import org.xutils.common.Callback.CommonCallback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhao
 * @description 网络请求
 * @date 2015-11-27上午10:49:57
 */
public enum NetManager {
    INSTANCE;

    NetManager() {

    }

    private static void buildParams(RequestParams params, HashMap<String, String> map) {
        //如果是登录，增加头部参数
        if (map.get(NetConstants.MESSAGENAME).equals(NetConstants.LOGIN)) {
            Apn.addHeads(map);
        }
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getKey() != NetConstants.MESSAGEGROUP) {
                params.addBodyParameter(entry.getKey(), entry.getValue());
            }
        }
    }


    public static void doGetHttp(HashMap<String, String> map, NetCommonCallback netCommonCallback) {

        RequestParams params = new RequestParams(NetConstants.HOST_URL);
        buildParams(params, map);
        params.setMethod(HttpMethod.GET);
        LogUtil.d("接口URL：" + NetConstants.HOST_URL + params.toString());

//      params.setSslSocketFactory(); // 设置ssl
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
