package com.liuzhao.onroad.net;

/**
 * Created by liuzhao on 2016/1/25.
 */
public class NetConstants {
    /*聚合URL*/
    public static final String HOST_URL_JUHE = "http://japi.juhe.cn";
    public static final String HOST_URL_LOCAL = "http://10.1.2.200";
    public static final String METHOD = "method";
    public static final String MESSAGENAME = "messageName";
    public static final String MESSAGEGROUP = "messageGroup";
    /*登录*/
    public static final String LOGIN = "login";
    /*每日一言组*/
    public static final String DAY_WORD = "/api/dayword";
    /*每日一言*/
    public static final String GET_DAY_WORD = DAY_WORD + "/getTodayWord";
    /*笑话*/
    public static final String JOKE_CONTENT = "/joke/content/list.from";
    /*图*/
    public static final String JOKE_IMG = "/joke/img/list.from";
}
