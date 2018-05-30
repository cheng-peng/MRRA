package com.cxp.lib_common.utils;

import com.cxp.lib_common.other.MapTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class JsonUtil {

    private static Gson gson = null;

    static {
        if (gson == null) {
//            gson =new Gson();
            //gson 转double解决方法
            gson =new GsonBuilder()
                    /**
                     * 重写map的反序列化
                     */
                    .registerTypeAdapter(new TypeToken<Map<String, Object>>() {
                    }.getType(), new MapTypeAdapter()).create();
        }
    }


    /**
     * 将对象转成json格式
     *
     * @param object
     * @return String
     */
    public static String BeanToString(Object object) {
        String json = null;
        if (gson != null) {
            json = gson.toJson(object);
        }
        return json;
    }


    /**
     * 将json转成特定的cls的对象
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> T JsonToBean(String json, Class<T> cls) {
        T t = null;
        if (gson != null) {
            //传入json对象和对象类型,将json转成对象
            t = gson.fromJson(json, cls);
        }
        return t;
    }

    /**
     * json字符串转成list
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> List<T> JsonToList(String json, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            //根据泛型返回解析指定的类型,TypeToken<List<T>>{}.getType()获取返回类型
            list = gson.fromJson(json, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * json字符串转成list中有map的
     *
     * @param json
     * @return
     */
    public static <T> List<Map<String, T>> JsonToListMap(String json) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(json,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * json字符串转成map的
     *
     * @param json
     * @return
     */
    public static <T> Map<String, T> JsonToMap(String json) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(json, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

}
