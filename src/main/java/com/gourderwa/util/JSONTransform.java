package com.gourderwa.util;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * 对象转换为 JSON 字符串
 *
 * @author wei.Li by 16/3/10
 */
public class JSONTransform {

    public static String jsonTransform(Object o) {
        return toJSONString(o);
    }

}
