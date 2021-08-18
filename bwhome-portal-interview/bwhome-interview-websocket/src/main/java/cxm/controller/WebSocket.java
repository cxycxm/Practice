package cxm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/imserver/{userId}")
@Component
public class WebSocket {

    private Session session;
    private String userId = "";
    private Logger logger = LoggerFactory.getLogger(WebSocket.class);
    private static ConcurrentHashMap<String, WebSocket> webSocketMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onopen(Session session, @PathParam("userId") String userId){
        this.session = session;
        this.userId = userId;
        if (!webSocketMap.containsKey(userId)){
            webSocketMap.put(userId, this);
            logger.info(userId + "在线");
        }
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        JSONObject jsonObject = JSON.parseObject(message);
        jsonObject.put("fromUserId", this.userId);
        String toUserId = jsonObject.getString("toUserId");
        String contentMessage = jsonObject.getString("contentMessage");
        logger.info(contentMessage);
        if (!StringUtils.isEmpty(toUserId) && webSocketMap.containsKey(toUserId)){
            webSocketMap.get(toUserId).session.getBasicRemote().sendText(this.userId + contentMessage);
        }else{
            logger.error("该用户不在线");
        }
    }

}
