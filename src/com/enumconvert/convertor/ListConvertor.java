package com.enumconvert.convertor;

import com.enumconvert.core.EnumConvert;
import com.enumconvert.iface.Convertor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class ListConvertor implements Convertor{

    @Override
    public List convert(Object object) throws IllegalAccessException, InvocationTargetException {
        List<?> objList = (List)object;
        objList = objList.stream().filter(item -> item != null)
                .map(obj -> EnumConvert.convert(obj))
                .collect(Collectors.toList());
        return objList;
    }
}
