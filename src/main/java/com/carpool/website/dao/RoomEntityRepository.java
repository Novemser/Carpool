package com.carpool.website.dao;

import com.carpool.domain.RoomEntity;

import com.carpool.domain.RoomState;
import com.carpool.domain.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

/**
 * Created by Novemser on 2016/11/27.
 */

public interface RoomEntityRepository extends JpaRepository<RoomEntity, Integer> {

    Page<RoomEntity> findByStartPointAndEndPointAndStartTime(String startPoint, String endPoint,

                                                             Date startTime, Pageable pageable);
    RoomEntity findByRoomname(String name);

    // 根据User找到何其在同一房间的用户
    @Query("select r from RoomEntity r " +
            "where :user in r.userParticipate")
    Page<RoomEntity> findUserRooms(@Param("user") UserEntity userEntity, Pageable pageable);

    RoomEntity findByHost(UserEntity host);

    @Modifying
    @Query("update RoomEntity room set " +
            "room.state=:qState " +
            "where room.id=:qId")
    void updateState(@Param("qState") RoomState state,
                     @Param("qId") int id);


}
