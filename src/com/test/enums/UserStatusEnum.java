package com.test.enums;

import com.enumconvert.annotation.ConvertMethod;

import java.util.Arrays;

public enum  UserStatusEnum {

    NORMAL("正常", 1),DELETE("已删除", -1);

    private String enumName;
    private Integer enumValue;

    UserStatusEnum(String enumName,Integer enumValue) {
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
        return Arrays.stream(UserStatusEnum.values()).filter(item -> item.value() == value).findFirst().get().enumName;
    }
}
