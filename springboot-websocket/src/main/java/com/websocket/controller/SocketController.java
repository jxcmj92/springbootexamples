package com.websocket.controller;

import com.websocket.websocket.WebSocketServer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class SocketController {

    @Resource
    private WebSocketServer webSocketServer;

    /**
     * 给指定用户推送消息
     * @param userName 用户名
     * @param message 消息
     */
    @GetMapping(value = "/socket")
    public void testSocket1(@RequestParam String userName, @RequestParam String message){
        webSocketServer.sendInfo(userName, message);
    }

    /**
     * 给所有用户推送消息
     * @param message 消息
     */
    @GetMapping(value = "/socket/all")
    public void testSocket2(@RequestParam String message){
        try {
            webSocketServer.onMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}