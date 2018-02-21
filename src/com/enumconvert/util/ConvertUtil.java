package com.enumconvert.util;

import com.enumconvert.core.Configuration;

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
}
