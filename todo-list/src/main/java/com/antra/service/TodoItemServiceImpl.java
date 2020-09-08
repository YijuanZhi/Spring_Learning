package com.antra.service;

import com.antra.model.TodoData;
import com.antra.model.TodoItem;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService{

    //fields
    private final TodoData data = new TodoData();

    //constr
    @Override
    public void addItem(@NonNull TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(@NonNull TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }

    @Override
    public TodoData getData() {
        return data;
    }
}
