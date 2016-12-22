package com.carpool.website.controller;

import com.carpool.domain.UserEntity;
import com.carpool.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import javax.servlet.http.Cookie;
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
    public String profile(HttpServletRequest request, ModelMap modelMap) {
        request.setAttribute("id", 3);
        request.setAttribute("active", "1");
        Cookie[] cookies=request.getCookies();
        String userId=this.userService.checkSessionIdentity(cookies[1].getValue());
        UserEntity userEntity=userService.getUserById(userId);
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
        Cookie[] cookies=request.getCookies();
        String userId=this.userService.checkSessionIdentity(cookies[1].getValue());
        if(request.getParameter("aliPay")!=""){
            userService.updateUserAlipay(userId,request.getParameter("aliPay"));
            change=true;
        }
        if(request.getParameter("QQ")!=""){
            userService.updateUserQQ(userId,request.getParameter("QQ"));
            change=true;
        }
        if(request.getParameter("WeChat")!=""){
            userService.updateUserWeChat(userId,request.getParameter("WeChat"));
            change=true;
        }
        if(change==true)
            return "redirect:/user";
        else
            return "user.profile.edit";
    }

    @PostMapping("/user/password")
    public String editPassword(ModelMap modelMap, HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        String userId=this.userService.checkSessionIdentity(cookies[1].getValue());
        UserEntity userEntity=userService.getUserById(userId);
        if(userEntity.getPassword()==request.getParameter("currentPassword")){
            userService.updateUserPassword(userId,request.getParameter("newPassword"));
            return "redirect:/user";
        }
        else{
            return "user.edit";
        }
    }

    @PostMapping("/user/photo")
    public String editPhoto(@RequestParam(value = "file", required = false)MultipartFile file,HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        String userId=this.userService.checkSessionIdentity(cookies[1].getValue());
        if (!file.isEmpty()) {
            try {
                String filePath = request.getSession().getServletContext().getRealPath("/")+"static/images/"
                        + userId+file.getOriginalFilename();
                file.transferTo(new File(filePath));
                String photoPath="/static/images/"+userId+file.getOriginalFilename();
                userService.updateUserPhoto(userId,photoPath);
            } catch (Exception e) {
                e.printStackTrace();
                return "user.edit";
            }
        }
        return "redirect:/user";
    }

}
