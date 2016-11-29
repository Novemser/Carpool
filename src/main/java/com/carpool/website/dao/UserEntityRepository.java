package com.carpool.website.dao;

import com.carpool.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qi on 2016/11/26.
 */

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

}
