package com.liuzhao.onroad.net;


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
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getKey() != NetConstants.METHOD) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
    }


    public <T> void doGetHttp(HashMap<String, String> map, NetCommonCallback netCommonCallback) {
        if (map == null || map.size() < 1)
            return;
        Object method = map.get(NetConstants.METHOD);
        RequestParams params = new RequestParams(NetConstants.HOST_URL_LOCAL + method);
        buildParams(params, map);
        params.setMethod(HttpMethod.GET);
        x.http().get(params, netCommonCallback);
    }

}
