package com.carpool.website.dao;

import com.carpool.domain.JourneyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by qi on 2016/11/26.
 */
@Repository
public interface JourneyEntityRepository extends JpaRepository<JourneyEntity, Integer> {
}
