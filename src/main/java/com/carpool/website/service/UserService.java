package com.carpool.website.service;

import com.carpool.domain.UserEntity;
import com.carpool.exception.UserNullException;

import com.carpool.domain.UserEntity;
import com.carpool.exception.UserNullException;
import com.carpool.website.dao.SessionRepository;
import com.carpool.website.dao.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.Base64;


/**
 * Created by qi on 2016/12/4.
 */

@Service
public class UserService {
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private EncryptionService encryptionService;
    @Autowired
    private SessionRepository sessionRepository;

    public UserEntity getUserById(String id)
    {
        UserEntity userEntity = userEntityRepository.findOne(id);
        if(userEntity==null)
            throw new UserNullException("getUserError","不存在的用户");
        return  userEntity;
    }



    public void saveUser(UserEntity userEntityToAdd) throws Exception{
        try{
            String inPw = userEntityToAdd.getPassword();
            String userId = userEntityToAdd.getId();
            String enPw = this.encryptionService.encipher(inPw) + this.encryptionService.encipher(userId);
            userEntityToAdd.setPassword(enPw);
            this.userEntityRepository.save(userEntityToAdd);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }


    private String checkSessionIdentity(String cookie){
        try{
            String seriseId = new String(Base64.getDecoder().decode(cookie));

            String userId = this.sessionRepository.findBySeriesId(seriseId.split(":")[0]).getUserId();

            return userId;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /***
     * 通过request的cookie来提取用户id
     * @param cookies request中包含的cookie
     * @return 如果用户合法返回用户id，否则返回null
     */
    public String getUserIdByCookie(Cookie[] cookies) {
        String userId = null;
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
            if (cookie.getName().equals("remember-me"))
                userId = checkSessionIdentity(cookie.getValue());
        }
        return userId;
    }
}
