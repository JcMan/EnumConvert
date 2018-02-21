package com.test.enums;

import com.enumconvert.annotation.ConvertMethod;

import java.util.Arrays;

public enum StatusEnum {

    APPLY("初始化", 1),FIRST_AUDIT("一审通过", 2),SECOND_AUDIT("二审通过", 3);

    private String enumName;
    private Integer enumValue;

    StatusEnum(String enumName,Integer enumValue) {
        this.enumName = enumName;
        this.enumValue = enumValue;
    }

    public String label() {
        return this.enumName;
    }

    public Integer value() {
        return this.enumValue;
    }

    @ConvertMethod
    public static Object toLabel(Integer value) {
        return Arrays.stream(StatusEnum.values()).filter(item -> item.value() == value).findFirst().get().enumName;
    }


}
