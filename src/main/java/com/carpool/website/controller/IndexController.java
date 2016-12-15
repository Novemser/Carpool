package com.carpool.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Project: Carpool
 * Package: com.carpool.website.controller
 * Author:  Novemser
 * 2016/12/15
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }
}
