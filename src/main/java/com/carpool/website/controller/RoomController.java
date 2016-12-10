package com.carpool.website.controller;

import com.carpool.domain.RoomEntity;
import com.carpool.website.model.Room;
import com.carpool.website.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String selectMethod(ModelMap modelMap) {
        if (!modelMap.containsKey("room")) {
            Room room = new Room();
            modelMap.addAttribute("room", room);
        }
        return "home.select";
    }

    @RequestMapping(value = "/detail")
    public String showDetail(@RequestParam int roomId, ModelMap modelMap) {
        RoomEntity entity = roomService.findById(roomId);
        modelMap.addAttribute("room", entity);

        return "room.detail";
    }

//    @RequestMapping(value = "/add",method = RequestMethod.GET)
//    public String addRoom(ModelMap modelMap) {
//        Room room = new Room();
//        modelMap.addAttribute("room", room);
//        return "addRoom";
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveNewRoom(@Valid Room room, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
        request.setAttribute("id", "2");
        modelMap.addAttribute("room", room);

        if (bindingResult.hasErrors()) {
            return "home.select";
        }

        return "room.addSucceed";
    }
}
