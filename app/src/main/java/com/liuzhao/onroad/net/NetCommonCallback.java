package com.liuzhao.onroad.net;

import android.content.Context;

import com.liuzhao.onroad.activity.BaseActivity;
import com.liuzhao.onroad.common.CommonConstants;
import com.liuzhao.onroad.entity.BaseResult;
import com.liuzhao.onroad.myinterface.NetResultCallBack;
import com.liuzhao.onroad.util.JsonUtils;
import com.liuzhao.onroad.util.Utils;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;

/**
 * Created by liuzhao on 2016/3/2.
 */
public class NetCommonCallback<T> implements Callback.CommonCallback<String> {
    private Class<T> clazz;
    private Context context;
    private NetResultCallBack<T> callBack;

    public NetCommonCallback(Class<T> clazz, Context context, NetResultCallBack<T> callBack) {
        this.clazz = clazz;
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public void onSuccess(String result) {
        LogUtil.d("接口返回数据：" + result);
        T t = JsonUtils.parseJson(result, clazz);
        BaseResult data = (BaseResult) t;
        if (data.getCode() == 1)
            callBack.onSuccess(t);

    }

    @Override
    public void onError(Throwable throwable, boolean isOnCallback) {
        LogUtil.d("接口返回" + throwable.getMessage());
        if (!Utils.isNetworkAvailable(context)) {
            Utils.showMyToast("网络不可用");
            callBack.onError(CommonConstants.STATUS_NO_INETNET, "");
        } else {
            Utils.showMyToast("请求接口失败");
            callBack.onError(CommonConstants.STATUS_SYSTEM_ERRO, throwable.getMessage());
        }

    }

    @Override
    public void onCancelled(CancelledException e) {
        LogUtil.d("接口返回onCancelled" + e.getMessage());
        Utils.showMyToast("取消网络请求");
    }

    @Override
    public void onFinished() {
        LogUtil.d("接口返回onFinished");
    }

}
