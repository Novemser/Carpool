package com.carpool.website.controller;

import com.carpool.website.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project: Carpool
 * Package: com.carpool.website.controller
 * Author:  Novemser
 * 2016/12/5
 */
@Controller
@RequestMapping("/home")
public class AppController {

    @RequestMapping(method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(ModelMap modelMap) {
        List<Room> rooms = new ArrayList<Room>();
        for (int i = 0; i < 10; i++) {
            Room room = new Room();
            room.setRoomname("房间" + " " + (i + 1));
            room.setCurrentNums(3);
            room.setNumberLimit(4);
            room.setStartPoint("嘉定校区");
            room.setEndPoint("虹桥机场");
            room.setStartDate(new Date(System.currentTimeMillis()).toString());
            room.setStartTime(new Date(System.currentTimeMillis()).toString());
            rooms.add(room);
        }
        modelMap.addAttribute("rooms", rooms);
        return "main";
    }
}
