package com.carpool.website.controller;

import com.carpool.website.service.ChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qi on 2016/11/26.
 */
@RestController
@RequestMapping("/Test")
public class TestController {

//    @Autowired
//    UserEntityRepository repository;
//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String home()
//    {
//        if(repository.findAll().size()==1)
//            return  "index";
//        else
//            throw  new RuntimeException();
//    }
    @Autowired
    ChatRecordService chatRecordService;


    @RequestMapping("/deleteChatRecord")
    String deleteChatRecordTest(){
        try{
            this.chatRecordService.deleteChatRecordById(10);
            return "True";
        }catch(Exception e){
            return "False";
        }
    }
}
