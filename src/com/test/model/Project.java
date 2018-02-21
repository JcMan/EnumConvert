package com.test.model;

import com.enumconvert.annotation.BindEnum;
import com.test.enums.StatusEnum;

import java.util.*;

public class Project {

    private String name;

    @BindEnum(enumClass = StatusEnum.class)
    private Integer status;

    @BindEnum(enumClass = StatusEnum.class, suffix = "EnumName")
    private Integer statusCopy = 2;

    private ArrayList<User> userList;

    private User owner;

    private Set<User> userSet;
    private Map<String, User> userMap;
    private Vector<User> userVector;

    private HashSet<Integer> hashSet;

    public Project(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public Project() {
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

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public Integer getStatusCopy() {
        return statusCopy;
    }

    public void setStatusCopy(Integer statusCopy) {
        this.statusCopy = statusCopy;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Vector<User> getUserVector() {
        return userVector;
    }

    public void setUserVector(Vector<User> userVector) {
        this.userVector = userVector;
    }
}
