package com.kevin.chatroom.temp;

import java.util.ArrayList;
import java.util.List;

public class SqlV {

    private List<String> list = new ArrayList<>();
    private String sql;

    public void put(String key, String value) {
        list.add(key + ":" + value);
    }

    public void sql(String sql) {
        this.sql = sql;
    }

}
