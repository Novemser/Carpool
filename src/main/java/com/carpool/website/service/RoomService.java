package com.carpool.website.service;

import com.carpool.domain.RoomEntity;
<<<<<<< HEAD
import com.carpool.website.dao.RoomEntityRepository;
import com.carpool.website.dao.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
=======
import com.carpool.domain.RoomState;
import com.carpool.domain.UserEntity;
import com.carpool.website.dao.RoomEntityRepository;
import com.carpool.website.dao.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
>>>>>>> 00f58bd46ed2e60a728b2fa2241b55a5a8cf5576

/**
 * Project: Carpool
 * Package: com.carpool.website.service
 * Author:  Novemser
 * 2016/11/29
 */
<<<<<<< HEAD
@Component
@ComponentScan
public class RoomService {
=======
@Service
public class RoomService {

>>>>>>> 00f58bd46ed2e60a728b2fa2241b55a5a8cf5576
    @Autowired
    private RoomEntityRepository roomEntityRepository;
    @Autowired
    private UserEntityRepository userEntityRepository;

<<<<<<< HEAD

    public void createRoome(Timestamp timeStamp) {
        RoomEntity entity = new RoomEntity();
        entity.setCreateTime(timeStamp);
        roomEntityRepository.save(entity);
=======
    public void createRoom(String roomname,
                           String startPoint,
                           String endPoint,
                           int numberLimit,
                           Date startTime,
                           String hostId) {
        // TODO:验证传入参数的合法性

        RoomEntity entity = new RoomEntity();
        entity.setRoomname(roomname);
        entity.setEndPoint(endPoint);
        entity.setNumberLimit(numberLimit);
        // 目前只有房主一个人
        entity.setCurrentNums(1);
        entity.setStartPoint(startPoint);
        entity.setStartTime(startTime);
        entity.setState(RoomState.UNLOCKED);

        // 获取系统当前时间戳
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        entity.setCreateTime(timestamp);

        UserEntity userEntity = userEntityRepository.findOne(hostId);

        entity.setHost(userEntity);

        Collection<UserEntity> userParticipate = entity.getUserParticipate();
        if (null == userParticipate)
            entity.setUserParticipate(new ArrayList<UserEntity>());
        // 这里把房主也要加到房间里?
        entity.getUserParticipate().add(userEntity);

        if (null == userEntity.getUserParticipateRooms())
            userEntity.setUserParticipateRooms(new ArrayList<RoomEntity>());

        userEntity.getUserParticipateRooms().add(entity);

        roomEntityRepository.saveAndFlush(entity);
    }

    public Page<RoomEntity> listUserRooms(String userId) {
        UserEntity userEntity = userEntityRepository.findOne(userId);
        Pageable p = new PageRequest(0, 10);
        return roomEntityRepository.findUserRooms(userEntity, p);
    }

    public void addUserToRoom(int roomId, String userId) {
        UserEntity user = userEntityRepository.findOne(userId);
        RoomEntity room = roomEntityRepository.findOne(roomId);
        room.getUserParticipate().add(user);
    }

    public Page<RoomEntity> listAllRooms(String startPoint, String endPoint,
                                      Date startTime) {
        // TODO:
        // 使用LocationUtil去检查point是否合法
        // 会调用百度API
        Pageable p = new PageRequest(0, 10);

        return roomEntityRepository.findByStartPointAndEndPointAndStartTime(startPoint,
                endPoint,
                startTime, p);
    }

    public Page<RoomEntity> listAvailableRooms(String startPoint, String endPoint,
                                               Date startTime) {
        Page<RoomEntity> roomEntities = listAllRooms(startPoint, endPoint, startTime);
        return roomEntities;
    }

    public void addUser(int roomId, String userId) {
        RoomEntity roomEntity = roomEntityRepository.findOne(roomId);
        UserEntity userEntity = userEntityRepository.findOne(userId);
        roomEntity.getUserParticipate().add(userEntity);
    }

    public void lockRoomById(int roomId) {
        changeRoomState(roomId, RoomState.LOCKED);
    }

    public void unLockRoomById(int roomId) {
        changeRoomState(roomId, RoomState.UNLOCKED);
    }

    public void startRoomById(int roomId) {
        changeRoomState(roomId, RoomState.STARTED);
    }

    public void endRoomById(int roomId) {
        changeRoomState(roomId, RoomState.END);
    }

    private void changeRoomState(int roomId, RoomState locked) {
        RoomEntity entity = roomEntityRepository.findOne(roomId);
        if (null == entity) {
            // TODO:
            // Log for error
            return;
        }
        roomEntityRepository.updateState(locked, roomId);
>>>>>>> 00f58bd46ed2e60a728b2fa2241b55a5a8cf5576
    }
}
