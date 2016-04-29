package com.gourderwa.service;

import com.gourderwa.cache.ApplicationCache;
import com.gourderwa.entity.Users;
import com.gourderwa.initdata.initSystemDatas;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wei.Li
 */
@Service
public class ProjectPropertiesService {

    @Value("${projectName}")
    private String projectName;
    @Value("${projectVersion}")
    private String projectVersion;
    @Value("${isInsertDemoData}")
    private boolean isInsertDemoData;
    @Value("${imagesUploadAddress}")
    private String imagesUploadAddress;

    @Resource
    private HibernateTemplate hibernateTemplate;

    public String getProjectName() {
        return projectName;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void initCacheData() {


        ApplicationCache.imagesUploadAddress = imagesUploadAddress;
    }

    /**
     * 必要初始化数据
     * 插入测试数据
     */
    public void insertDemoData() {

        if (!this.isInsertDemoData) {

            //admin 用户校验
            if (
                    hibernateTemplate.findByCriteria(
                            DetachedCriteria.forClass(Users.class)
                                    .add(Restrictions.eq("userName", "admin"))
                    ).isEmpty()) {
                hibernateTemplate.save(initSystemDatas.ADMIN);
            }

            return;
        }

        try {
            for (Users users : initSystemDatas.getUsers()) {
                hibernateTemplate.save(users);
            }

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
