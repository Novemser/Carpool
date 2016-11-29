package com.carpool.website.dao;

import com.carpool.domain.UserEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by qi on 2016/11/26.
 */
@ComponentScan
@Component
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,String>{

}
