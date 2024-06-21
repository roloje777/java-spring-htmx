package com.roloje.javaspringhtmx.controllers;

import com.roloje.javaspringhtmx.model.TodoItem;
import com.roloje.javaspringhtmx.model.TodoList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class TodoController {

    @GetMapping("/")
    public String items(Model model) {
        System.out.println("BEGIN items");
        model.addAttribute("itemList", TodoList.getInstance().getList());
        return "index";
    }
    @PostMapping("/todos/{id}/complete")
//  @ResponseBody
    public String completeTodo(@PathVariable Integer id, Model model) {
        TodoItem item = null;
        for (TodoItem existingItem : TodoList.getInstance().getList()) {
            if (existingItem.getId().equals(id)) {
                item = existingItem;
                break;
            }
        }
        if (item != null) {
            item.setCompleted(!item.isCompleted());
        }
        model.addAttribute("item",item);
        return "todo";
    }
    @PostMapping("/todos")
//  @ResponseBody
    public String createTodo(Model model, @ModelAttribute TodoItem newTodo) {
        int nextId = TodoList.getInstance().getList().stream().mapToInt(TodoItem::getId).max().orElse(0) + 1;
        newTodo.setId(nextId);
        System.out.println("newTodo: " + newTodo);
        TodoList.getInstance().getList().add(newTodo);
//    return "<li>"+newTodo.getDescription()+"<input type='checkbox' th:checked='${item.isCompleted}' hx-trigger='click' th:hx-post='|/todos/${item.id}/complete|'></li>";
        model.addAttribute("item", newTodo);
        return "todo";
    }
    @PostMapping("/todos/{id}/delete")
    @ResponseBody
    public String deleteTodo(@PathVariable Integer id) {
        for (int i = 0;  i < TodoList.getInstance().getList().size(); i++) {
            TodoItem item = TodoList.getInstance().getList().get(i);
            if (item.getId() == id) {
                TodoList.getInstance().getList().remove(i);
                break;
            }
        }
        return "";
    }
}
