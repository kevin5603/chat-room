package com.kevin.chatroom.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "file")
public class FileConfig {

    private String uploadPath;

    private String staticAccessPath;

    private String directoryMapping;


}
