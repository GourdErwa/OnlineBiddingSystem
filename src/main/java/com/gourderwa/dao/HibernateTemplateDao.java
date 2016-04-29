package com.gourderwa.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;

/**
 * @author Wei.Li on 2016/4/21.
 */
public class HibernateTemplateDao {

    @Resource
    HibernateTemplate hibernateTemplate;

}
