package com.gourderwa.initdata;

import com.google.common.collect.Lists;
import com.gourderwa.entity.Tender;
import com.gourderwa.entity.Users;
import com.gourderwa.util.TimesUtils;

import java.util.Date;
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

    public static List<Tender> getTenders() {

        final List<Tender> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(new Tender("招标示例数据--" + i, com.gourderwa.entity.Tender.State.BeingPublicized, "StandardBiddingBook.pdf", "说明00" + i, TimesUtils.DATE_FORMATTER.format(new Date())));
        }

        return list;
    }


}
