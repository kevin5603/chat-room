package com.kevin.chatroom.temp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExeSql {

    public String execute(SqlV sqlV) {
        log.info("logic ...");
        return sqlV.toString();
    }
}
