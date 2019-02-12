package com.bsfy.superutilsmodel.math;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者: Created by wangyu on 2019/2/12.
 */

public class MathUtils {

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null){
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }
}
