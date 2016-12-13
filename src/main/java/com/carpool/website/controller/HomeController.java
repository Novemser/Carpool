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
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pageCount", roomService.getRoomPageCount());

        return "main";
    }

    @GetMapping("test")
    public String get() {
        return "pages/test";
    }
}
