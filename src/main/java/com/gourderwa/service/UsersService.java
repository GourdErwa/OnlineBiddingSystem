package com.gourderwa.service;

import com.gourderwa.dao.UsersDao;
import com.gourderwa.entity.Users;
import com.gourderwa.model.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Service
public class UsersService {

    @Resource
    private UsersDao usersDao;


    public Result verifyLogin(String userName, String passWd) {
        return usersDao.verifyLogin(userName, passWd);
    }

    public Result searchUsers() {
        return new Result(true, usersDao.searchUsers());
    }

    public Result createUser(Users users) {
        List<?> list = usersDao.validateUserName(users);
        return list.isEmpty() ? usersDao.createUser(users) : new Result(false);
    }

    public Result deleteUser(int usersId) {
        return usersDao.deleteUser(usersId);
    }

    public Users searchUserById(int usersId) {
        return usersDao.searchUserById(usersId);
    }

    public Result updateUser(Users users) {
        List<?> list = usersDao.validateUpdateName(users);
        return list.isEmpty() ? usersDao.updateUser(users) : new Result(false);
    }
}
