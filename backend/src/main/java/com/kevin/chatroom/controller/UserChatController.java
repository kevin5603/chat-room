package com.kevin.chatroom.controller;

import com.kevin.chatroom.model.TextMessage;
import com.kevin.chatroom.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@AllArgsConstructor
public class UserChatController {
    private final MessageService messageService;

    private final SimpMessagingTemplate template;

    @MessageMapping("/chat")
    public void chat(@Payload TextMessage textMessage) {
        template.convertAndSend( "/topic/chatRoom", textMessage);
    }

    @RequestMapping(path="/broadcast", method=POST)
    @ResponseBody
    public void broadcast() {
        String text = "這是廣播";
        TextMessage textMessage = new TextMessage(text, "ADMIN", "ALL");
        this.template.convertAndSend("/topic/chatRoom", textMessage);
    }
}
