package com.test.model;

import com.enumconvert.annotation.BindEnum;
import com.test.enums.UserStatusEnum;

public class User {

    private String name;
    @BindEnum(enumClass = UserStatusEnum.class)
    private Integer status;

    public User() {

    }

    public User(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
