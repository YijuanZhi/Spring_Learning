package com.antra.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;


//Lombok: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields,
//and @Setter on all non-final fields, and @RequiredArgsConstructor!
@Data
@EqualsAndHashCode(of = "id") //we only want to compare the id and title instead of all the fields
public class TodoItem {

    //fields
    private int id; //default value is 0, this property is used to see if the item is new or the updated item
    private String title;
    private String details;
    private LocalDate deadline;

    public TodoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }
}
