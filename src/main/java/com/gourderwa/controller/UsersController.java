package com.gourderwa.controller;

import com.gourderwa.cache.ActiveMenu;
import com.gourderwa.entity.Users;
import com.gourderwa.model.Result;
import com.gourderwa.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Controller
@RequestMapping("users")
public class UsersController {

    @Resource
    private UsersService usersService;

    @RequestMapping(value = "goShowAllUsersIndexPage")
    public ModelAndView goShowAllUsersIndexPage() {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.showAllUsers");
        modelAndView.addObject("activeMenu", ActiveMenu.usersMenu);
        return modelAndView;
    }

    @RequestMapping(value = "goCreateUsersIndexPage")
    public ModelAndView goCreateUsersIndexPage() {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.createUsers");
        modelAndView.addObject("activeMenu", ActiveMenu.myMenu);
        return modelAndView;
    }

    @RequestMapping(value = "goUpdateUsersIndexPage")
    public ModelAndView goUpdateUsersIndexPage(String usersId) {
        Users users = usersService.searchUserById(Integer.parseInt(usersId));
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.updateUsers");
        modelAndView.addObject("updateUsers", users);

        modelAndView.addObject("activeMenu", ActiveMenu.usersMenu);
        return modelAndView;
    }

    @RequestMapping(value = "searchUsers")
    public
    @ResponseBody
    Result searchUsers() throws Exception {

        return usersService.searchUsers();
    }

    @RequestMapping(value = "deleteUser")
    public
    @ResponseBody
    Result deleteUser(int usersId) throws Exception {
        return usersService.deleteUser(usersId);
    }


    @RequestMapping(value = "createUsers")
    public
    @ResponseBody
    Result createUsers(Users users) throws Exception {
        return usersService.createUser(users);
    }


    @RequestMapping(value = "updateUser")
    public
    @ResponseBody
    Result updateUser(Users users) throws Exception {
        return usersService.updateUser(users);
    }
}
