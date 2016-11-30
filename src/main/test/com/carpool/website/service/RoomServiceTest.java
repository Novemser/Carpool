package com.carpool.website.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Project: Carpool
 * Package: com.carpool.website.service
 * Author:  Novemser
 * 2016/11/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @Test
    public void createRoom() throws Exception {

        roomService.createRoom(
                "土豪你好",
                "嘉定校区",
                "虹桥机场",
                4,
                new Date(),
                "1452681"
        );
    }

    @Test
    public void listUserRooms() throws Exception {

    }

    @Test
    public void listAllRooms() throws Exception {

    }

    @Test
    public void addUser() throws Exception {

    }

    @Test
    public void lockRoomById() throws Exception {

    }

}