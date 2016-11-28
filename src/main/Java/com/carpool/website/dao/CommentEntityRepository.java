package com.carpool.website.dao;

import com.carpool.domain.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by qi on 2016/11/26.
 */
@Component
@Repository
public interface CommentEntityRepository extends JpaRepository<CommentEntity,Integer>{
}
