package com.antra.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {

    //fields
    private static int idValue = 1;
    //you should be using list for this case
    //if you use HashMap, every item is a key to value pair, you cannot directly access title, details, etc.
    private final List<TodoItem> items = new ArrayList<>();

    //constructor
    public TodoData() {
        //add some dummy date using the addItem method so it sets the id field
        addItem(new TodoItem("first", "first details", LocalDate.now()));
        addItem(new TodoItem("second", "second details", LocalDate.now()));
        addItem(new TodoItem("third", "third details", LocalDate.now()));
    }

    //public methods
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    //Lombok: @NonNull annotation will check if toAdd is null, if so it will throw an exception
    public void addItem(@NonNull TodoItem toAdd){
        toAdd.setId(idValue++);
        items.add(toAdd);
    }

    public void removeItem(int id) {
        for(int i = 0; i < items.size(); ++i){
            TodoItem cur = items.get(i);
            if(cur.getId() == id){
                items.remove(cur);
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        for(int i = 0; i < items.size(); ++i){
            TodoItem cur = items.get(i);
            if(cur.getId() == id){
                return cur;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        for(int i = 0; i < items.size(); ++i){
            TodoItem cur = items.get(i);
            if(cur.equals(toUpdate)){
                items.set(i, toUpdate);
                break;
            }
        }
    }
}
