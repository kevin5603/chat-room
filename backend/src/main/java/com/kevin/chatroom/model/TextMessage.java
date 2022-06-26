package com.kevin.chatroom.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class TextMessage{
    private String text;
    private String sender;
    private String receiver;

//    private Long id;
//    private ContentType contentType = ContentType.TEXT;
//    private String content;
//    private Instant creatTime;
//    private String sender;
}
