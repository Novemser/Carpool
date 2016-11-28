package com.carpool.website.controller;

import com.carpool.website.dao.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qi on 2016/11/26.
 */
@Controller
public class TestController {

    @Autowired
    UserEntityRepository repository;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home()
    {
        if(repository.findAll().size()==1)
            return  "index";
        else
            throw  new RuntimeException();
    }
}
