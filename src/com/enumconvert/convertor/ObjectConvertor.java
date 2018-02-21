package com.enumconvert.convertor;

import com.alibaba.fastjson.JSONObject;
import com.enumconvert.annotation.BindEnum;
import com.enumconvert.core.Configuration;
import com.enumconvert.iface.Convertor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectConvertor implements Convertor{

    @Override
    public Object convert(Object object) throws IllegalAccessException, InvocationTargetException {
        Map<String, Object> ret = null;
        try {
            ret = (Map<String, Object>)JSONObject.toJSON(object);
        }catch (Exception e) {
            return object;
        }
        List<Field> fieldList = Arrays.stream(object.getClass().getDeclaredFields())
                .collect(Collectors.toList());
        List<Field> tmp = new ArrayList<>();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            field.setAccessible(true);
            if (field.get(object) != null) {
                tmp.add(field);
            }
        }
        fieldList = tmp;
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            field.setAccessible(true);
            if (field.getAnnotation(BindEnum.class) != null) {
                BindEnum bindEnum = field.getAnnotation(BindEnum.class);
                Class enumClass = bindEnum.enumClass();
                Method convertMethod = Configuration.getInstance().getMethod(enumClass);
                Object value = field.get(object);
                String suffix = bindEnum.suffix();
                Object label = convertMethod.invoke(null, value);
                ret.put(field.getName() + suffix, label);
            }
        }
        fieldList = fieldList.stream().filter(field -> field.getAnnotation(BindEnum.class) == null).collect(Collectors.toList());
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            Convertor convertor = Configuration.getInstance().getConvertor(field.getType());
            ret.put(field.getName(), convertor.convert(field.get(object)));
        }
        return ret;
    }
}
