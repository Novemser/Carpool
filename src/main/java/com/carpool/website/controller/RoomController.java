package com.carpool.website.controller;

import com.carpool.website.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Project: Carpool
 * Package: com.carpool.website.controller
 * Author:  Novemser
 * 2016/11/30
 */
@Controller
@RequestMapping("/room")
public class RoomController {

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addRoom(ModelMap modelMap) {
        Room room = new Room();
        modelMap.addAttribute("room", room);
        return "addRoom";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveNewRoom(@Valid Room room, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            return "addRoom";
        }
        modelMap.addAttribute("roomSucceed", "添加房间成功！");
        return "redirect:addRoomSucceed";
    }
}
