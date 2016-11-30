package com.carpool.website.service;

import com.carpool.domain.RoomEntity;
import com.carpool.website.dao.RoomEntityRepository;
import com.carpool.website.dao.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Project: Carpool
 * Package: com.carpool.website.service
 * Author:  Novemser
 * 2016/11/29
 */
@Component
@ComponentScan
public class RoomService {
    @Autowired
    private RoomEntityRepository roomEntityRepository;
    @Autowired
    private UserEntityRepository userEntityRepository;


    public void createRoome(Timestamp timeStamp) {
        RoomEntity entity = new RoomEntity();
        entity.setCreateTime(timeStamp);
        roomEntityRepository.save(entity);
    }
}
