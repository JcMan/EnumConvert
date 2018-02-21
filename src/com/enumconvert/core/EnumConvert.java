package com.enumconvert.core;

import com.enumconvert.iface.Convertor;

/**
 *@author PJC
 * time: 2018/2/21
 * desc: This framework implements the process of automatically converting the value of an enumerated class into a label
 */
public class EnumConvert {

    public static Object convert(Object obj) {
        Object ret = obj;
        Convertor convertor = Configuration.getInstance().getConvertor(obj.getClass());
        try {
            ret = convertor.convert(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
