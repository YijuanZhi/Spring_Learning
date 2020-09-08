package com.antra.contoller;

import com.antra.model.TodoData;
import com.antra.model.TodoItem;
import com.antra.service.TodoItemService;
import com.antra.util.AttributeNames;
import com.antra.util.Mappings;
import com.antra.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.AttributeView;
import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    //fields
    private final TodoItemService todoItemService;

    //constructor
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    //model attributes
    @ModelAttribute("wtfTodoData")
    public TodoData todoData(){
        return todoItemService.getData();
    }

    //handler methods
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
        //if we get the id in RequestParam, we first examine if the item with this id exists
        TodoItem todoItem = todoItemService.getItem(id);
        if(todoItem == null) todoItem = new TodoItem("", "", LocalDate.now());
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        if(todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        }else{
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS; //after submit the form, redirect to a different mapping
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;
    }
}
