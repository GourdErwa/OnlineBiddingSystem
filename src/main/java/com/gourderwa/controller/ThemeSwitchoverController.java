package com.gourderwa.controller;

import com.gourderwa.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 主题切换
 *
 * @author wei.Li
 */
@Controller
@RequestMapping("themeSwitchover")
public class ThemeSwitchoverController {

    /**
     * 主题切换
     */
    @RequestMapping(value = "")
    public
    @ResponseBody
    Result themeSwitchover(HttpServletRequest request, String themeSwitchover) {
        request.getSession().setAttribute("themeSwitchover", themeSwitchover);
        return new Result(true);
    }
}
