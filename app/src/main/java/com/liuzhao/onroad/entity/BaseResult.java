package com.liuzhao.onroad.entity;

import java.io.Serializable;

/**
 * @author liuzhao on 2015-9-5下午8:44:41 邮箱：63993048@qq.com
 *         <p/>
 *         所有接口返回result的父类
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1L;
    public String error_code;
    public String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}
