package com.carpool.website.controller;

import com.carpool.domain.UserEntity;
import com.carpool.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Project: Carpool
 * Package: com.carpool.website.controller
 * Author:  Novemser
 * 2016/12/2
 */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logIn() {
        return "pages/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "pages/register";
    }

    @GetMapping("/user")
    //public String profile(HttpServletRequest request,@RequestParam String userId, ModelMap modelMap) {
    public String profile(HttpServletRequest request, ModelMap modelMap) {
        request.setAttribute("id", 3);
        request.setAttribute("active", "1");
        //UserEntity userEntity=userService.getUserById(userId);
        UserEntity userEntity=userService.getUserById("1452714");
        modelMap.addAttribute("user",userEntity);
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

    @PostMapping("/user/edit")
    public String edit(ModelMap modelMap, HttpServletRequest request){
        boolean change=false;
        //更新有错
        if(request.getParameter("aliPay")!=""){
            userService.updateUserAlipay("1452714",request.getParameter("aliPay"));
            change=true;
        }
        if(request.getParameter("QQ")!=""){
            userService.updateUserQQ("1452714",request.getParameter("QQ"));
            change=true;
        }
        if(request.getParameter("WeChat")!=""){
            userService.updateUserWeChat("1452714",request.getParameter("WeChat"));
            change=true;
        }
        if(change==true)
            return "redirect:/user";
        else
            return "user.profile.edit";
    }

    @PostMapping("/user/password")
    public String editPassword(ModelMap modelMap, HttpServletRequest request){
        UserEntity userEntity=userService.getUserById("1452714");
        if(userEntity.getPassword()==request.getParameter("currentPassword")){
            userService.updateUserPassword("1452714",request.getParameter("newPassword"));
            return "redirect:/user";
        }
        else{
            return "user.edit";
        }
    }

}
