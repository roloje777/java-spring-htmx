package com.roloje.javaspringhtmx.bootstrap;

import com.roloje.javaspringhtmx.model.TodoItem;
import com.roloje.javaspringhtmx.model.TodoList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
            System.out.println("***Loading data ***");
            List<TodoItem> list = TodoList.getInstance().getList();
            list.add(new TodoItem(0,"Make the bed"));
            list.add(new TodoItem(1,"Buy a new hat"));
            list.add(new TodoItem(2,"Listen to the birds singing"));


        System.out.println(TodoList.getInstance().getList().size() +" items loaded ...");
    }
}
