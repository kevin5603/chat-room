package com.kevin.chatroom.controller;

import com.kevin.chatroom.model.TextMessage;
import com.kevin.chatroom.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.kevin.chatroom.constant.MessageConst.CHAT_ROOM;

@Controller
@AllArgsConstructor
@Slf4j
public class UserChatController {
    private final MessageService messageService;

    @MessageMapping("/chat")
    public void chat(@Payload TextMessage textMessage) {
        log.info("{}", textMessage);
        messageService.sendMessageToUser(textMessage);
    }

    @PostMapping("broadcast")
    @ResponseBody
    public void broadcast() {
//        String text = "這是廣播";
//        TextMessage textMessage = new TextMessage(text, "ADMIN", new String[]{"ALL"}, "111");
//        this.template.convertAndSend("/topic/chatRoom", textMessage);
    }
}
