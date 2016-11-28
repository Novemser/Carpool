package com.carpool.repository;

import com.carpool.domin.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qi on 2016/11/27.
 */
public interface RoomEntityRepository extends JpaRepository<RoomEntity,Integer> {
}
