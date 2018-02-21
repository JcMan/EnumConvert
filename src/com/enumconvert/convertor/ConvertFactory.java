package com.enumconvert.convertor;

import com.enumconvert.iface.Convertor;

public class ConvertFactory {
    public static Convertor getObjectConvertor() {
        return new ObjectConvertor();
    }
    public static Convertor getListConvertor() {
        return new ListConvertor();
    }
    public static Convertor getSetConvertor() {
        return new SetConvertor();
    }
    public static Convertor getMapConvertor() {
        return new MapConvertor();
    }
}
