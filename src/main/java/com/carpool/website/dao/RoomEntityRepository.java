package com.carpool.website.dao;

import com.carpool.domain.RoomEntity;
import com.carpool.domain.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * Created by Novemser on 2016/11/27.
 */

public interface RoomEntityRepository extends JpaRepository<RoomEntity, Integer> {

    Page<RoomEntity> findByStartPointAndEndPointAndStartTime(String startPoint, String endPoint,
                                                             Date startTime);

    @Query("select r.userParticipate from RoomEntity r")
    Page<UserEntity> findUsers();

    RoomEntity findByHost(UserEntity host);


}
