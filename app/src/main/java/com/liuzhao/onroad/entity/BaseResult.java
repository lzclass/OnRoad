package com.liuzhao.onroad.entity;

import java.io.Serializable;

/**
 * @author liuzhao on 2015-9-5下午8:44:41 邮箱：63993048@qq.com
 * 
 *         所有接口返回result的父类
 */
public class BaseResult implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 成功
	 */
	public static final String RESULT_OK = "100";
	/**
	 * 异常结果
	 */
	public static final String EXCEPTION = "102";

	/** 状态码（100成功，否则失败） */
	public String result;
	/** 信息 */
	public String message;
}
