package com.kevin.chatroom.service;

import com.kevin.chatroom.model.TextMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import static com.kevin.chatroom.constant.MessageConst.CHAT_ROOM;

@Service
@AllArgsConstructor
@Slf4j
public class MessageService {

    private final SimpMessagingTemplate template;
    public void sendMessage() {

    }

    public void sendMessageToUser(TextMessage textMessage) {
        template.convertAndSendToUser(textMessage.getRoomId(), CHAT_ROOM, textMessage);
    }
}
