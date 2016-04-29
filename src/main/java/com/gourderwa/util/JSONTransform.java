package com.gourderwa.util;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author wei.Li by 16/3/10
 */
public class JSONTransform {

    public static String jsonTransform(Object o) {
        return toJSONString(o);
    }

}
