package com.carpool.website.dao;

import com.carpool.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by qi on 2016/11/26.
 */

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,String>{

}
