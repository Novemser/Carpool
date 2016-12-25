package com.carpool.website.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.carpool.domain.ChatRecordEntity;
import com.carpool.domain.RoomEntity;
import com.carpool.domain.UserEntity;
import com.carpool.domain.UserUnreceivedChatRecord;
import com.carpool.website.dao.ChatRecordRepository;
import com.carpool.website.dao.RoomEntityRepository;
import com.carpool.website.dao.UserEntityRepository;
import com.carpool.website.dao.UserUnreceivedRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.text.DateFormat;
import java.util.*;

/**
 * Created by deado on 2016/12/20.
 */

@Service
public class RoomWebSocketHandler extends TextWebSocketHandler {

    private String[] month = {"January", "February", "March", "April",  "May", "June", "July", "August", "September", "October" ,"November", "December"};

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

    // {roomid: [userid1, userid2, ......]}
    private static Map<String, ArrayList<WebSocketSession>>  roomDomain = new HashMap<String, ArrayList<WebSocketSession>>();

    private static Map<String, ArrayList<String>>  roomMembers = new HashMap<String, ArrayList<String>>();

    @Autowired
    private WebSocketService webSocketService;

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message){
        String messageContent = message.getPayload().toString();
        JSONObject messageJson = JSON.parseObject(messageContent);

        Integer type = messageJson.getInteger("type");
        switch(type){
            case(1): this.handleMessageTypeOne(session,messageJson);break;
            case(2): this.handleMessageTypeTwo(session);break;
            case(3): this.handleMessageTypeThree(session,messageJson);break;
        }

    }



    private void handleMessageTypeOne(WebSocketSession session, JSONObject messageJson){
        //retrieve info from message
        String userId = messageJson.getString("userid");
        String room = messageJson.getString("room");
        String content = messageJson.getString("chatContent");

        ArrayList<WebSocketSession> roomSpace = roomDomain.get(room);

        //save message
        ChatRecordEntity cre = new ChatRecordEntity(new Date(),content,
                this.userEntityRepository.findById(userId),this.roomEntityRepository.findOne(Integer.valueOf(room)));
        this.chatRecordRepository.save(cre);

        //send
        this.sendMessageToUsers(cre, roomSpace, messageJson);


    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        return;
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        for(Map.Entry<String, ArrayList<WebSocketSession>> entry: roomDomain.entrySet()){
            if(entry.getValue().contains(session)){
                roomDomain.get(entry.getKey()).remove(session);
                break;
            }
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     *
     * Send messages to all users in a room
     *
     */
    @Transactional
    private void sendMessageToUsers(ChatRecordEntity cre, ArrayList<WebSocketSession> roomSpace, JSONObject msg) {
        Integer monthIndex = Integer.valueOf(msg.getString("month"));

        msg.replace("month", msg.get("month"), this.month[monthIndex-1]);

        //generate message
        String messageStr = msg.toJSONString();
        TextMessage message = new TextMessage(messageStr);
        ArrayList<String> roomPatis = (ArrayList<String>)roomMembers.get(msg.getString("room")).clone();

        //send to users
        for(WebSocketSession session: roomSpace){
            String target = session.getPrincipal().getName();
            try{
                if(session.isOpen()){
                    session.sendMessage(message);
                    if(roomPatis.contains(target)){
                        roomPatis.remove(target);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }

        //save the unsent message in database
        for(String remainUsers: roomPatis){
            UserUnreceivedChatRecord uUC = new UserUnreceivedChatRecord();
            uUC.setChatRecordEntity(cre);
            uUC.setUserId(remainUsers);
            this.userUnreceivedRecordRepository.save(uUC);
        }

    }

    private void handleMessageTypeTwo(WebSocketSession session){
//        try{
//            String userId = session.getPrincipal().getName();
//            String userProfileImg = userService.getUserProfileImgSrc(userId);
//            List<UserUnreceivedChatRecord> uucList = this.userUnreceivedRecordRepository.findByUserId(userId);
//            this.userUnreceivedRecordRepository.deleteByUserId(userId);
//            if(0 == uucList.size()){
////                throw new Exception();
//                return;
//            }
//
//            for(UserUnreceivedChatRecord uuc:uucList){
//
//                StringBuilder msg = new StringBuilder("{ \"count\":");
//                msg.append(uucList.size() + ",");
//                String content = uuc.getChatRecordEntity().getCommenttext();
//                msg.append("\"content\":" + "\"" + content + "\",");
//                String sender = uuc.getChatRecordEntity().getSender().getUsername();
//                msg.append("\"sender\":" + "\"" + sender + "\",");
//                String roomId = new  Integer(uuc.getChatRecordEntity().getRoom().getId()).toString();
//                msg.append("\"roomId\":" + "\"" + roomId + "\",");
//                String time = DateFormat.getDateTimeInstance().format(uuc.getChatRecordEntity().getCommenttime());
//                msg.append("\"src\":\"").append(userProfileImg.replace("_","")).append("\",");
//                msg.append("\"time\":" + "\"" + time + "\"}");
//                session.sendMessage(new TextMessage(msg.toString()));
//            }
//
//        }catch(Exception e){
//            e.printStackTrace();
//            try{
//                session.sendMessage(new TextMessage("[]"));
//            }catch(Exception e2){
//                //ignore
//            }
//
//        }



    }

    @SuppressWarnings("deprecation")
    private void handleMessageTypeThree(WebSocketSession session, JSONObject messageJson){
        Integer room = messageJson.getInteger("roomId");
        List<ChatRecordEntity> chatList = this.chatRecordRepository.getAllChatOfRoom(room);

        //add this room to roomDomain
        if(!roomDomain.containsKey(room.toString())){
            ArrayList<WebSocketSession> value = new ArrayList<WebSocketSession>();
            roomDomain.put(room.toString(), value);

            RoomEntity roomEntity = this.roomEntityRepository.findById(room);

            Collection<UserEntity> roomMemberColl = roomEntity.getUserParticipate();
            ArrayList<String> roomMemberList = new ArrayList<String>();
            for(UserEntity userEntity: roomMemberColl){
                roomMemberList.add(userEntity.getId());
            }
            roomMembers.put(room.toString(), roomMemberList);
        }
        //add this session to roomSpace
        ArrayList<WebSocketSession> roomSpace = roomDomain.get(room.toString());
        if(!roomSpace.contains(session)){
            roomSpace.add(session);
        }

        //send back the chat history
        for(ChatRecordEntity cre : chatList){
            String year = Integer.toString(cre.getCommenttime().getYear());
            String month = Integer.toString(cre.getCommenttime().getMonth());
            String day = Integer.toString(cre.getCommenttime().getDay());
            String hour = Integer.toString(cre.getCommenttime().getHours());
            String minute = Integer.toString(cre.getCommenttime().getMinutes());
            String userProfileImg = userService.getUserProfileImgSrc(cre.getSender().getId());

            String msg = "{ \"type\":1, \"userid\":\""+cre.getSender().getId() + "\", \"username\":\"" + cre.getSender().getUsername()
                    + "\", \"room\":" + room + ", \"year\":"+year + ", \"month\":"+ month + ",\"day\":" +day+ ",\"hour\":"
                    + hour + ",\"minute\":" + minute + ",\"chatContent\":\"" + cre.getCommenttext() + "\"," +
                    "\"src\":\"" + userProfileImg.replace("_","") + "\"}";
            try{
                session.sendMessage(new TextMessage(msg));
            }catch(Exception e){

            }
        }
    }


}
