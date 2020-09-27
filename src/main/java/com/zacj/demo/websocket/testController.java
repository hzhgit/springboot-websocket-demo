package com.zacj.demo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class testController {
    @Autowired
    WebSocket webSocket;

    @ResponseBody
    @GetMapping("/sendTo")
    public String sendTo(@RequestParam("userId") String userId, @RequestParam("msg") String msg) throws IOException {
        webSocket.sendMessageTo(msg,userId);
        return "推送成功";
    }

    @ResponseBody
    @GetMapping("/sendAll")
    public String sendAll(@RequestParam("msg") String msg) throws IOException {
        String fromUserId="system";
        webSocket.sendMessageAll(msg,fromUserId);
        return "推送成功";
    }

}
