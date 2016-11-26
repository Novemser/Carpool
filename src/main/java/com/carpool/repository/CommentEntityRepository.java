package com.carpool.repository;

import com.carpool.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qi on 2016/11/26.
 */
public interface CommentEntityRepository extends JpaRepository<CommentEntity,Integer>{
}
