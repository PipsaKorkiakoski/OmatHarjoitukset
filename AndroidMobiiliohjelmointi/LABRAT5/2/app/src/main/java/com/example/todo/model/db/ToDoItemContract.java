package com.example.todo.model.db;

import android.provider.BaseColumns;

public final class ToDoItemContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ToDoItemContract() {}

    /* Inner class that defines the table contents */
    public static class ToDoItem implements BaseColumns {
        public static final String TABLE_NAME = "todos";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME_TITLE = "todotitle";
        public static final String COLUMN_TODO_DESCRIPTION = "tododescription";
        public static final String COLUMN_TODO_DATE = "tododate";


    }
}
