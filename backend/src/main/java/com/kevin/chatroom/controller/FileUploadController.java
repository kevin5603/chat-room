package com.kevin.chatroom.controller;

import com.kevin.chatroom.model.TextMessage;
import com.kevin.chatroom.service.MessageService;
import com.kevin.chatroom.service.UploadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@AllArgsConstructor
@Slf4j
public class FileUploadController {

    private final UploadService uploadService;
    private final MessageService messageService;

    @PostMapping("api/uploadFile")
    public void upload(@RequestParam("sender") String sender, @RequestParam("receiver") String receiver,
                       @RequestParam("file") MultipartFile multipartFile) {
        log.info("sender:" + sender);
        log.info("receiver:" + receiver);
        var uploadPath = uploadService.upload(multipartFile);
        if (StringUtils.isNotEmpty(uploadPath)) {
            // todo 發送圖片到聊天室
            messageService.sendMessage();
        } else {
            // 讓前端alert 告訴使用者上傳失敗
        }

    }
}
