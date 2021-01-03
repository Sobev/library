package com.library.Interceptor;

import com.library.entities.Admin;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class MessageSocketHandler extends TextWebSocketHandler {
    public static final Map<String, WebSocketSession> USER_SOCKET_SESSION;

    static {
        //initialize store session
        USER_SOCKET_SESSION = new HashMap<>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Admin admin = (Admin) session.getAttributes().get("user");
        if (admin != null) {
            TextMessage message = new TextMessage(admin.getAdminId() + "踏着轻盈的进来了" + new Date().toString());

            USER_SOCKET_SESSION.put(admin.getAdminId(), session);
            sendMessageToAll(message);
        } else throw new RuntimeException("用户登录信息失效");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Admin admin = (Admin) session.getAttributes().get("user");
        System.out.println("server 接收到 " + admin.getAdminId() + " 发送的 " + payload);
        //session.sendMessage(new TextMessage("server 发送给 " + admin.getAdminId() + " 消息 " + payload + " "
        //+ new Date().toString()));
        sendMessageToAll(message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //remove this admin
        Admin admin = (Admin) session.getAttributes().get("user");
        if (admin != null)
            USER_SOCKET_SESSION.remove(admin.getAdminId());
        sendMessageToAll(new TextMessage(admin.getAdminId() + "left"));
    }

    //send to all
    private void sendMessageToAll(TextMessage message) {
        Set<Map.Entry<String, WebSocketSession>> entrySet = USER_SOCKET_SESSION.entrySet();
        for (Map.Entry<String, WebSocketSession> entry : entrySet) {
            WebSocketSession session = entry.getValue();
            if (session.isOpen()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            session.sendMessage(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }
}
