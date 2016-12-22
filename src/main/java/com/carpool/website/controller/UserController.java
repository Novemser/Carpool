package com.carpool.website.controller;

import com.carpool.domain.RoomEntity;
import com.carpool.exception.UserNullException;
import com.carpool.website.service.RoomService;
import com.carpool.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Project: Carpool
 * Package: com.carpool.website.controller
 * Author:  Novemser
 * 2016/12/2
 */
@Controller
public class UserController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

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
    public String showJourney(HttpServletRequest request, ModelMap modelMap) {
        request.setAttribute("id", 3);
        request.setAttribute("active", "2");

        String userId = userService.getUserIdByCookie(request.getCookies());
        // 当前用户非法登录 拒绝修改 返回细节界面
        if (null == userId)
            throw new UserNullException("抱歉", "请通过正规渠道登录");

        modelMap.addAttribute("userId", userId);

        List<RoomEntity> roomEntities = roomService.listUserRooms(userId);
        modelMap.addAttribute("rooms", roomEntities);

        return "user.profile.journey";
    }
}
