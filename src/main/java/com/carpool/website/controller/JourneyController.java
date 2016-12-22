package com.carpool.website.controller;

import com.carpool.domain.JourneyEntity;
import com.carpool.exception.UserNullException;
import com.carpool.website.model.JourneyCommentDetail;
import com.carpool.website.model.MyTrack;
import com.carpool.website.service.JourneyService;
import com.carpool.website.service.UserService;
import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by qi on 2016/12/1.
 */

@Controller
@RequestMapping(value = "/journey")
public class JourneyController {


    @Autowired
    private JourneyService journeyService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getMyJourneyAsHost/{userid}",method = RequestMethod.GET)
    public String getMyJourneyAsHost(@PathVariable("userid")String userid, @Param("currentPage")Integer currentPage, ModelMap modelMap)
    {
        if(currentPage==null) currentPage = 0;
        Page<JourneyEntity> journeyEntities = journeyService.getMyJourneyAsHost(userid,currentPage);
        modelMap.addAttribute("journeys",journeyEntities);
        modelMap.addAttribute("currentPage",currentPage);
        modelMap.addAttribute("type","我是房主");
        return "journey/journeys";
    }

    @RequestMapping(value = "/getAllJourneys/{userid}",method = RequestMethod.GET)
    public String getAllJourneys(@PathVariable("userid")String userid,@Param("currentPage") Integer currentPage,ModelMap modelMap)
    {
        if(currentPage==null) currentPage = 0;
        Page<JourneyEntity> journeyEntities = journeyService.getAllJourneys(userid,currentPage);
        modelMap.addAttribute("journeys",journeyEntities);
        modelMap.addAttribute("currentPage",currentPage);
        modelMap.addAttribute("type","全部出行");
        return "journey/journeys";
    }

    @RequestMapping(value = "/getJourneyCommentDetail/{journeyId}",method = RequestMethod.GET)
    @ResponseBody
    public List<JourneyCommentDetail> getJourneyCommentDetail(@PathVariable("journeyId")Integer journeyId, @RequestParam("userid")String userid)
    {
        return journeyService.getJourneyCommentDetails(journeyId,userid);
    }


    @RequestMapping(value = "/getMyTrack",method = RequestMethod.GET)
    public String getMyTrack(ModelMap modelMap, HttpServletRequest request)
    {
        String userId = userService.getUserIdByCookie(request.getCookies());
        if(userId == null)
            throw  new UserNullException("error","当前会话不存在任何用户！");
        System.out.println(userId);
        List<MyTrack> myTracks = journeyService.getMyTrack(userId);
        modelMap.addAttribute("mytracks",myTracks);
        return "journey/myTrack";
    }
}
