package com.kevin.chatroom.service;

import com.kevin.chatroom.config.FileConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Service
@AllArgsConstructor
@Slf4j
public class UploadService {

    private final FileConfig fileConfig;
    public String upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            String uploadPath = fileConfig.getUploadPath() + fileName;
            log.info(uploadPath);
            Path path = Path.of(uploadPath);
            multipartFile.transferTo(path);
            return uploadPath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
