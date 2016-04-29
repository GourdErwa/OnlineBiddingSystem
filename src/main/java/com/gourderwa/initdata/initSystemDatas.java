package com.gourderwa.initdata;

import com.google.common.collect.Lists;
import com.gourderwa.entity.Users;

import java.util.List;

/**
 * 插入测试数据
 *
 * @author wei.Li
 */
public class initSystemDatas {

    public static final Users
            ADMIN = new Users("admin", "admin", "18601341999", "admin@163.com", "admin", 2);

    public static List<Users> getUsers() {

        final List<Users> list = Lists.newArrayList(ADMIN);
        for (int i = 0; i < 100; i++) {
            list.add(new Users("用户-" + i, i + "", "18601341992", i + "-tyut@163.com", "北京市海淀区", 1));
        }

        return list;
    }

}
