package com.carpool.website.service;

import com.alibaba.fastjson.JSONObject;
import com.carpool.domain.UserEntity;
import com.carpool.website.dao.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by deado on 2016/12/16.
 */


public class AuthenticationService implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    private EncryptionService encryptionService;


    private UserService userService;

    private BenYanAuthService benYanAuthService ;

    public AuthenticationService (UserDetailsService uDS, UserService uS){
        this.userDetailsService = uDS;
        this.encryptionService = new EncryptionService();
        this.benYanAuthService = new BenYanAuthService();
        this.userService = uS;
    }


    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {

        try{
            UserDetails userDetails = (UserDetails)this.userDetailsService.loadUserByUsername(authentication.getName());
            String userName = authentication.getName();
            String inputPw = authentication.getCredentials().toString();
            String pw = this.encryptionService.encipher(inputPw) + this.encryptionService.encipher(userName);


            if(0 == userName.compareTo(userDetails.getUsername())&&
               0 == pw.compareTo(userDetails.getPassword())){
                return new UsernamePasswordAuthenticationToken(
                        userDetails, pw, userDetails.getAuthorities()
                );
            }

            throw  new Exception();

        }catch(Exception e){
            String username = authentication.getName();
            String pw = authentication.getCredentials().toString();

            //authenticate in 4m3
            JSONObject jsonRet = new JSONObject();
            this.benYanAuthService.verify(username, pw, jsonRet);

            if(0 == jsonRet.size()){ // if not found
                return null;
            }else{  // found
                UserEntity userEntity = new UserEntity(username,jsonRet.getString("name"), pw,
                        (byte)0, 0.0, "", 0,"", "","");
                userEntity.setReceivedComments(0);

                //add the new user to database
                try{
                    this.userService.saveUser(userEntity);

                }catch(Exception saveUserException){
                    return null;
                }
                //return the result
                UserDetails userDetails = (UserDetails)this.userDetailsService.loadUserByUsername(authentication.getName());
                return new UsernamePasswordAuthenticationToken(
                        userDetails, pw, authentication.getAuthorities()
                );

            }
        }
    }


    public boolean supports(Class authentication){
        return true;
    }

}
