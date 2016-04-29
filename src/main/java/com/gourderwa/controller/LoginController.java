package com.gourderwa.controller;

import com.gourderwa.cache.ActiveMenu;
import com.gourderwa.entity.Users;
import com.gourderwa.model.Result;
import com.gourderwa.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wei.Li
 */
@Controller
@RequestMapping("login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private UsersService usersService;

    //登录页面
    @RequestMapping(value = "goIndexPage")
    public ModelAndView goIndexPage(HttpServletRequest request) {

        final ModelAndView modelAndView = new ModelAndView("layouts.application_layout.login");
        modelAndView.addObject("activeMenu", ActiveMenu.loginMenu);
        modelAndView.addObject("Referer", request.getHeader("Referer"));
        return modelAndView;
    }

    //验证登录信息
    @RequestMapping(value = "verifyLogin")
    public
    @ResponseBody
    Result verifyLogin(HttpServletRequest request, String userName, String passWd)
            throws Exception {

        final Result result = usersService.verifyLogin(userName, passWd);
        if (result.isSuccess()) {
            final Users user = ((Users) result.getData());
            final HttpSession session = request.getSession();
            session.setAttribute("users", user);
            if (user.getType() == 2) {
                session.setAttribute("isAdmin", true);
            }
        }

        return result;
    }

    //注销登录
    @RequestMapping(value = "loginOut")
    public ModelAndView loginOut(HttpServletRequest request)
            throws Exception {

        final HttpSession session = request.getSession();
        session.removeAttribute("users");
        session.removeAttribute("isAdmin");
        return new ModelAndView("redirect:/home/goIndexPage");
    }

}
