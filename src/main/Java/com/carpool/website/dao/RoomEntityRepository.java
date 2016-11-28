package com.carpool.website.dao;

import com.carpool.domain.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by qi on 2016/11/27.
 */
@Component
@Repository
public interface RoomEntityRepository extends JpaRepository<RoomEntity, Integer> {

}
