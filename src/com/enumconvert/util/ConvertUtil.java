package com.enumconvert.util;

import com.enumconvert.core.Configuration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertUtil {

    public static boolean isInterfaceImpl(Class clz) {
        return Configuration.getInstance().getConvertKeys().stream()
                .filter(item -> item != Object.class)
                .filter(item -> item.isAssignableFrom(clz))
                .count() > 0;
    }

    public static Class getInterfaceClass(Class clz) {
        return Configuration.getInstance().getConvertKeys().stream()
                .filter(item -> item != Object.class)
                .filter(item -> item.isAssignableFrom(clz))
                .findFirst()
                .get();
    }

    public static List<Field> getAllFields(Class clz) {
        List<Field> fieldList = new ArrayList<>();
        while (clz != null) {
            fieldList.addAll(Arrays.asList(clz.getDeclaredFields()));
            clz = clz.getSuperclass();
        }
        return fieldList;
    }
}
