package com.carpool.website.service;

import com.carpool.domain.UserEntity;
import com.carpool.exception.UserNullException;
import com.carpool.website.dao.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qi on 2016/12/4.
 */

@Service
public class UserService {
    @Autowired
    UserEntityRepository userEntityRepository;
    public UserEntity getUserById(String id)
    {
        UserEntity userEntity = userEntityRepository.findOne(id);
        if(userEntity==null)
            throw new UserNullException("getUserError","不存在的用户");
        return  userEntity;
    }

    public void updateUserAlipay(String id,String alipay)
    {
        UserEntity userEntity = userEntityRepository.findOne(id);
        if(userEntity==null)
            throw new UserNullException("getUserError","不存在的用户");
        userEntity.setAlipay(alipay);
    }

    public void updateUserQQ(String id,String QQ)
    {
        UserEntity userEntity = userEntityRepository.findOne(id);
        if(userEntity==null)
            throw new UserNullException("getUserError","不存在的用户");
        userEntity.setQqAccount(QQ);
    }

    public void updateUserWeChat(String id,String WeChat)
    {
        UserEntity userEntity = userEntityRepository.findOne(id);
        if(userEntity==null)
            throw new UserNullException("getUserError","不存在的用户");
        userEntity.setWechatAccount(WeChat);
    }
}
