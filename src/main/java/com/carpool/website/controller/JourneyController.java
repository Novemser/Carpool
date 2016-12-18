package com.carpool.website.controller;

import com.carpool.domain.JourneyEntity;
import com.carpool.website.model.JourneyCommentDetail;
import com.carpool.website.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by qi on 2016/12/1.
 */

@Controller
@RequestMapping(value = "/journey")
public class JourneyController {


    @Autowired
    private JourneyService journeyService;

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
}
