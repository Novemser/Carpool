package com.carpool.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Project: Carpool
 * Package: com.carpool.website.controller
 * Author:  Novemser
 * 2016/12/2
 */
@Controller
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logIn() {
        return "pages/login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "pages/register";
    }

    @GetMapping("/user")
    public String profile(HttpServletRequest request) {
        request.setAttribute("id", 3);
        request.setAttribute("active", "1");
        return "user.profile";
    }

    @GetMapping("/user/edit")
    public String editProfile(ModelMap modelMap, HttpServletRequest request) {
        request.setAttribute("id", 3);
        request.setAttribute("active", "3");
        return "user.profile.edit";
    }

    @GetMapping("/user/journey")
    public String showJourney(HttpServletRequest request) {
        request.setAttribute("id", 3);
        request.setAttribute("active", "2");
        return "user.profile.journey";
    }
}
