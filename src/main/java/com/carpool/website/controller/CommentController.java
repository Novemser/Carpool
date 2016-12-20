package com.carpool.website.controller;

import com.carpool.domain.CommentEntity;
import com.carpool.domain.UserEntity;
import com.carpool.website.model.Comment;
import com.carpool.website.service.CommentService;
import com.carpool.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by qi on 2016/11/30.
 */

@Controller
@RequestMapping("/comment")
//@SessionAttributes("userid")
//@SessionAttributes("userid")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/getSendedComment")
    public String getComments()
    {
        return  "comment/sendedComments";
    }

    @RequestMapping(value = "/getReceivedComment/{userid}",method = RequestMethod.GET)
    public String getReceivedComment(@PathVariable("userid")String userid, @Param("currentPage")Integer currentPage, ModelMap modelMap,HttpSession session)
    {
        if(currentPage==null)
            currentPage = 0;
        UserEntity userEntity = userService.getUserById(userid);
        Page<CommentEntity> commentEntities = commentService.getRecievedComment(userid,currentPage);
        modelMap.addAttribute("receivedComments",commentEntities);
        modelMap.addAttribute("currentPage",currentPage);
        modelMap.addAttribute("user",userEntity);
        return  "comment/receivedComments";
    }

    @RequestMapping(value = "/getSendedComment/{userid}",method = RequestMethod.GET)
    public String getSendedComment(@PathVariable("userid")String userid,@Param("currentPage")Integer currentPage, ModelMap modelMap)
    {
        if(currentPage==null)
            currentPage = 0;
        Page<CommentEntity> commentEntities = commentService.getSendedComment(userid,currentPage);
        modelMap.addAttribute("sendedComments",commentEntities);
        modelMap.addAttribute("currentPage",currentPage);
        return  "comment/sendedComments";
    }

    @RequestMapping(value = "/getOthersComment/{otherUserId}",method = RequestMethod.GET)
    public String getOthersComment(@PathVariable("otherUserId")String otherUserid,@Param("currentPage") Integer currentPage,ModelMap modelMap)
    {
        if(currentPage==null) currentPage = 0;
        UserEntity userEntity = userService.getUserById(otherUserid);
        Page<CommentEntity> commentEntities = commentService.getRecievedComment(otherUserid,currentPage);
        modelMap.addAttribute("otherUser",userEntity);
        modelMap.addAttribute("comments",commentEntities);
        return "comment/lookOtherComments";
    }

    @RequestMapping(value = "/makeComment")
    @ResponseBody
    public String addComment(Comment comment)
    {
        if(commentService.addComment(comment))
            return "success";
        return "failed";
    }
}
