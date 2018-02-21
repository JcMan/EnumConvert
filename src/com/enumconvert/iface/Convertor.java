package com.enumconvert.iface;

import java.lang.reflect.InvocationTargetException;

public interface Convertor {
    Object convert(Object object) throws IllegalAccessException, InvocationTargetException;
}
