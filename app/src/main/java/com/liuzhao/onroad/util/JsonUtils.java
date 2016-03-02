package com.liuzhao.onroad.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * Created by liuzhao on 2016/3/1.
 */
public class JsonUtils {

    /**
     * 解析Bean数据
     *
     * @param jsonStr JSON字符串
     * @param clazz   解析Bean
     * @return
     */
    public static <T> T parseJson(String jsonStr, Class<T> clazz) {
        T t = JSON.parseObject(jsonStr, clazz);
        return t;
    }

    /**
     * 解析Bean数据
     *
     * @param jsonStr JSON字符串
     * @param clazz   解析Bean
     * @return
     */
    public static <T> T parseJsonObject(String jsonStr, Class<T> clazz) {
        T t = JSON.parseObject(jsonStr, new TypeReference<T>() {
        });
        return t;

    }
}
