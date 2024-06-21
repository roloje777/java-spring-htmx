package com.roloje.javaspringhtmx.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TodoItem {

    private Integer id;
    private String description;
    private boolean completed;

    public TodoItem(Integer id, String description) {
        this.description = description;
        this.completed = false;
        this.id = id;
    }

}
