package com.carpool.website.service;

import com.carpool.domain.CommentEntity;
import com.carpool.domain.JourneyEntity;
import com.carpool.domain.RoomEntity;
import com.carpool.domain.UserEntity;
import com.carpool.exception.JourneyException;
import com.carpool.website.dao.CommentEntityRepository;
import com.carpool.website.dao.JourneyEntityRepository;
import com.carpool.website.dao.RoomEntityRepository;
import com.carpool.website.model.JourneyCommentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by qi on 2016/12/1.
 */

@Service
public class JourneyService extends PageSevice {

    @Autowired
    JourneyEntityRepository journeyEntityRepository;
    @Autowired
    CommentEntityRepository commentEntityRepository;

    @Autowired
    RoomEntityRepository roomEntityRepository;

    //分页得到自己作为房主的出行

    public Page<JourneyEntity> getMyJourneyAsHost(String userid, int currentPage)
    {
        setCurrentPage(currentPage);
        Pageable pageable = buidPage(Sort.Direction.DESC,"startTime");
        return journeyEntityRepository.findByRoomHostId(userid,pageable);
    }

    //得到自己所有的出行
    public Page<JourneyEntity> getAllJourneys(String userid, int currentPage)
    {
        setCurrentPage(currentPage);
        Pageable pageable = buidPage(Sort.Direction.DESC,"startTime");
        return journeyEntityRepository.getAllJourneyByByUSerId(userid,pageable);
    }


    //得到自己作为房主出行的数量
    public int getTotalJourneyAsHost(String userid)
    {
        return journeyEntityRepository.countIdByRoomHostId(userid);
    }

    //得到自己所有的出行
    public int getTotalJourney(String userid)
    {
        return journeyEntityRepository.getJourneyNums(userid);
    }


    //得到某个人 某次出行的细节 对谁进行评价，是否评价等
    public List<JourneyCommentDetail> getJourneyCommentDetails(Integer journeyId, String userid)
    {
        List<JourneyCommentDetail> journeyCommentDetails = new ArrayList<JourneyCommentDetail>();

        //通过行程的编号得到该行程对应房间的编号
        Integer roomid = journeyEntityRepository.findRoomById(journeyId);

        //得到对应的房间实体
         RoomEntity room = roomEntityRepository.findOne(roomid);
        if(room==null) throw new JourneyException("journeyToRoom",journeyId+"编号行程对应的房间不存在！");
        //遍历房间每个参与者，判断有没有评价过该用户，如果有得到评论细节
        Collection<UserEntity> userEntities = room.getUserParticipate();
        for (UserEntity userEntity :userEntities) {
                if(userEntity.getId().equals(userid))
                {
                    continue;
                }
                JourneyCommentDetail journeyCommentDetail
                        = new JourneyCommentDetail();
             journeyCommentDetail.setTargetUserId(userEntity.getId());
            journeyCommentDetail.setCommentText(userEntity.getUsername());
            journeyCommentDetail.setJourneyId(journeyId);
            journeyCommentDetail.setSourceUserId(userid);
            journeyCommentDetail.setTargetUserName(userEntity.getUsername());
            //找到该用户在某次行程中对某特定用户的评论，如果没有表示还没有评论
            CommentEntity comment = commentEntityRepository.findBySourceUserIdAndTargetUserIdAndJourneyId(userid,
                    userEntity.getId(),journeyId);
            if(comment==null)
            {
                journeyCommentDetail.setHasCommented(false);
            }
            else
            {
                journeyCommentDetail.setHasCommented(true);
                journeyCommentDetail.setCommentText(comment.getCommentText());
                journeyCommentDetail.setCredit(comment.getCredit());
                journeyCommentDetail.setCommentTime(comment.getCommentTime());
            }
            journeyCommentDetails.add(journeyCommentDetail);
        }
        return  journeyCommentDetails;
    }
}
