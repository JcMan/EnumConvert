package com.enumconvert.convertor;

import com.enumconvert.core.EnumConvert;
import com.enumconvert.iface.Convertor;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

public class SetConvertor implements Convertor{
    @Override
    public Set<?> convert(Object object) throws IllegalAccessException, InvocationTargetException {
        Set<?> objSet = (Set<?>) object;
        objSet = objSet.stream().filter(item -> item != null)
                .map(obj -> EnumConvert.convert(obj))
                .collect(Collectors.toSet());
        return objSet;
    }
}
