package com.kevin.chatroom.controller;

import com.kevin.chatroom.config.FileConfig;
import com.kevin.chatroom.model.TextMessage;
import com.kevin.chatroom.service.MessageService;
import com.kevin.chatroom.service.UploadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.kevin.chatroom.model.ContentType.IMAGE;

@RestController
@AllArgsConstructor
@Slf4j
public class FileUploadController {

    private final UploadService uploadService;
    private final FileConfig fileConfig;
    private final MessageService messageService;

    @PostMapping("api/uploadFile")
    public void upload(@RequestParam("roomId") String roomId, @RequestParam("sender") String sender, @RequestParam("file") MultipartFile multipartFile) {
        log.info("roomId:" + roomId);
        var uploadPath = uploadService.upload(multipartFile);
        if (StringUtils.isNotEmpty(uploadPath)) {
            // todo 發送圖片到聊天室
            TextMessage message = new TextMessage();
            message.setRoomId(roomId);
            message.setText("http://localhost:8080/" + fileConfig.getUploadPath() + multipartFile.getOriginalFilename());
            message.setContentType(IMAGE);
            message.setSender(sender);
            log.info("{}", message);
            messageService.sendMessageToUser(message);
        } else {
            // 讓前端alert 告訴使用者上傳失敗
        }

    }
}
