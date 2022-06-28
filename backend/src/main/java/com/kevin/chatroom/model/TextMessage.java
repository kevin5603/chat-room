package com.kevin.chatroom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextMessage{
    private String text;
    private String sender;
    private String[] receiver;
    private String roomId;
    private ContentType contentType;

//    private Long id;
//    private String content;
//    private Instant creatTime;
//    private String sender;
}
