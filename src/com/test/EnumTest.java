package com.test;

import com.alibaba.fastjson.JSONObject;
import com.enumconvert.core.EnumConvert;
import com.test.model.Project;
import com.test.model.User;
import org.junit.Test;

import java.util.*;

public class EnumTest {

    @Test
    public void test01() throws Exception {
        Project project = new Project("项目1",1);
        User user1 = new User("Tom", 1);
        User user2 = new User("Jane", -1);
        User owner = new User("DuoDuo", 1);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        project.setUserList(users);
        project.setOwner(owner);

        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);
        project.setUserSet(userSet);
        Vector<User> userVector = new Vector<>();
        userVector.add(user1);
        project.setUserVector(userVector);

        Map<String, User> userMap = new HashMap<>();
        userMap.put(user1.getName(), user1);
        project.setUserMap(userMap);

        System.out.println(JSONObject.toJSON(project));
        System.out.println(EnumConvert.convert(project));
    }
}
