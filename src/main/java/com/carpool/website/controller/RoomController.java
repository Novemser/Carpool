package com.carpool.website.controller;

import com.carpool.website.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String selectMethod(ModelMap modelMap) {
        if (!modelMap.containsKey("room")) {
            Room room = new Room();
            modelMap.addAttribute("room", room);
        }
        return "home/select";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addRoom(ModelMap modelMap) {
        Room room = new Room();
        modelMap.addAttribute("room", room);
        return "addRoom";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveNewRoom(@Valid Room room, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("room", room);
            return "pages/selectRoomType";
        }
        modelMap.addAttribute("roomSucceed", "添加房间成功！");
        return "redirect:addRoomSucceed";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        System.out.println("Call init binder");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(true);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }

    @GetMapping("/test")
    public @ResponseBody String getTestString() {
        return "这是一个测试";
    }
}
