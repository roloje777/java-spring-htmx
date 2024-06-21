package com.roloje.javaspringhtmx.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private static final TodoList instance = new TodoList();
    List<TodoItem> list;


    private TodoList(){
        list = new ArrayList<>();

    };

    public static TodoList getInstance(){
        return instance;
    }
    public List<TodoItem> getList() {
        return list;
    }

    public void setList(List<TodoItem> list) {
        this.list = list;
    }



}
