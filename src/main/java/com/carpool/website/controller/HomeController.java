package com.carpool.website.controller;

import com.carpool.configuration.GlobalConstants;
import com.carpool.domain.RoomEntity;
import com.carpool.website.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Project: Carpool
 * Package: com.carpool.website.controller
 * Author:  Novemser
 * 2016/12/5
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
        return mainPage(0, GlobalConstants.HOME_CARPOOL_PAGE_SIZE, modelMap);
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = GlobalConstants.HOME_CARPOOL_PAGE_SIZE_STR) Integer size,
            ModelMap modelMap) {

        Page<RoomEntity> roomEntities = roomService.findRoom(page, size);
        modelMap.addAttribute("roomPage", roomEntities);

//        List<Room> rooms = new ArrayList<Room>();
//        for (int i = 0; i < 10; i++) {
//            Room room = new Room();
//            room.setRoomname("房间" + " " + (i + 1));
//            room.setCurrentNums(3);
//            room.setNumberLimit(4);
//            room.setStartPoint("嘉定校区");
//            room.setEndPoint("虹桥机场");
//            room.setStartDate(new Date(System.currentTimeMillis()).toString());
//            room.setStartTime(new Date(System.currentTimeMillis()).toString());
//            rooms.add(room);
//        }
//        modelMap.addAttribute("rooms", rooms);
        return "main";
    }

//    @RequestMapping(value = "/select", method = RequestMethod.GET)
//    public String selectRoom(ModelMap modelMap) {
//        if (!modelMap.containsKey("room")) {
//            Room room = new Room();
//            modelMap.addAttribute("room", room);
//        }
//        return "home.select";
//    }

    @GetMapping("test")
    public String get() {
        return "pages/test";
    }
}
