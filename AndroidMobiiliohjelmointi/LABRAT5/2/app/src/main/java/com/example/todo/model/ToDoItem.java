package com.example.todo.model;

public class ToDoItem {

    String date = null;
    String title = null;
    String description = null;
    long id;

    public ToDoItem(long id, String  date, String title, String description) {

        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



