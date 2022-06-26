package com.kevin.chatroom.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevin.chatroom.model.Greeting;
import com.kevin.chatroom.model.HelloMessage;
import com.kevin.chatroom.model.TextMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping({"/hello"})
    @SendTo("/topic/greetings")
    public TextMessage greeting(@Payload TextMessage message) throws Exception {
        return message;
    }


}
