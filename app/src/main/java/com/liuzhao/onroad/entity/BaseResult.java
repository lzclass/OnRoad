package com.liuzhao.onroad.entity;

import java.io.Serializable;

/**
 * @author liuzhao on 2015-9-5下午8:44:41 邮箱：63993048@qq.com
 *         <p/>
 *         所有接口返回result的父类
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1L;
    /*0失败1成功2参数错误: 一般是缺少或参数值不符合要求3帐号已存在4验证码错误500服务器错误404接口不存在422token无效*/
    public String code;
    public String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
