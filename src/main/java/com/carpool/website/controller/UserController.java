package com.carpool.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
