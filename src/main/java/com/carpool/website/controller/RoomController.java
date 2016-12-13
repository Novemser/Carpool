package com.carpool.website.controller;

import com.carpool.domain.RoomEntity;
import com.carpool.website.model.Room;
import com.carpool.website.model.RoomSelection;
import com.carpool.website.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @GetMapping("/select")
    public String selectMethod(ModelMap modelMap) {
        if (!modelMap.containsKey("room")) {
            Room room = new Room();
            modelMap.addAttribute("room", room);
        }
        return "home.select";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int roomId, ModelMap modelMap) {
        RoomEntity entity = roomService.findById(roomId);
        modelMap.addAttribute("room", entity);

        return "room.detail";
    }

    @GetMapping("/count/room")
    public @ResponseBody Integer getRoomCount() {
        return roomService.getRoomsCount();
    }

    @GetMapping("/count/page")
    public @ResponseBody Integer getRoomPageCount() {
        return roomService.getRoomPageCount();
    }

    @GetMapping("/create")
    public String saveNewRoom(ModelMap modelMap) {
        Room room = new Room();
        modelMap.addAttribute("room", room);
        return "room.create";
    }

    @GetMapping("/join")
    public String joinRoom(ModelMap modelMap) {
        RoomSelection roomSelection = new RoomSelection();
        modelMap.addAttribute("roomSelection", roomSelection);
        return "room.join";
    }

    @PostMapping("/join")
    public String joinRoom(@Valid RoomSelection room, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
        request.setAttribute("id", "2");

        if (bindingResult.hasErrors()) {
            return "room.join";
        }
        RoomSelection selection = (RoomSelection) modelMap.get("roomSelection");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = format.parse(selection.getStartDate());
            Page<RoomEntity> roomEntities = roomService.listRoomsInDays(selection.getStartPoint(), selection.getEndPoint(), date, 1);
            modelMap.addAttribute("roomPage", roomEntities);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        // TODO:修改

        return "home";
    }

    @PostMapping("/create")
    public String saveNewRoomPost(@Valid Room room, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
        request.setAttribute("id", "2");
        modelMap.addAttribute("room", room);

        if (bindingResult.hasErrors()) {
            return "room.create";
        }

        return "room.addSucceed";
    }
}
