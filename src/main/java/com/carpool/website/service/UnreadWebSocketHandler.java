package com.carpool.website.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.carpool.domain.ChatRecordEntity;
import com.carpool.domain.UserUnreceivedChatRecord;
import com.carpool.website.dao.ChatRecordRepository;
import com.carpool.website.dao.RoomEntityRepository;
import com.carpool.website.dao.UserEntityRepository;
import com.carpool.website.dao.UserUnreceivedRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by deado on 2016/12/25.
 */
@Service
public class UnreadWebSocketHandler extends TextWebSocketHandler {
    @Autowired
    private RoomEntityRepository roomEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserUnreceivedRecordRepository userUnreceivedRecordRepository;

    @Autowired
    private ChatRecordRepository chatRecordRepository;

    @Autowired
    private UserService userService;


    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message){
        try{
            String userId = session.getPrincipal().getName();
            String userProfileImg = userService.getUserProfileImgSrc(userId);
            List<UserUnreceivedChatRecord> uucList = this.userUnreceivedRecordRepository.findByUserId(userId);
            this.userUnreceivedRecordRepository.deleteByUserId(userId);
            if(0 == uucList.size()){
//                throw new Exception();
                return;
            }

            for(UserUnreceivedChatRecord uuc:uucList){

                StringBuilder msg = new StringBuilder("{ \"count\":");
                msg.append(uucList.size() + ",");
                String content = uuc.getChatRecordEntity().getCommenttext();
                msg.append("\"content\":" + "\"" + content + "\",");
                String sender = uuc.getChatRecordEntity().getSender().getUsername();
                msg.append("\"sender\":" + "\"" + sender + "\",");
                String roomId = new  Integer(uuc.getChatRecordEntity().getRoom().getId()).toString();
                msg.append("\"roomId\":" + "\"" + roomId + "\",");
                String time = DateFormat.getDateTimeInstance().format(uuc.getChatRecordEntity().getCommenttime());
                msg.append("\"src\":\"").append(userProfileImg.replace("_","")).append("\",");
                msg.append("\"time\":" + "\"" + time + "\"}");
                session.sendMessage(new TextMessage(msg.toString()));
            }

        }catch(Exception e){
            e.printStackTrace();
            try{
                session.sendMessage(new TextMessage("[]"));
            }catch(Exception e2){
                //ignore
            }

        }


    }


}
