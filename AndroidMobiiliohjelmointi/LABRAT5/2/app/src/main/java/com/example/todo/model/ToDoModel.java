package com.example.todo.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.todo.model.db.ToDoItemContract;
import com.example.todo.model.db.ToDoItemDbHelper;

import java.util.ArrayList;

public class ToDoModel {


    ToDoItemDbHelper mDbHelper = null;
    ArrayList<ToDoItem> data=null;
    Cursor cursor = null;
    long id;


    public ToDoModel(Context context) {
        this.mDbHelper = new ToDoItemDbHelper(context);
    }

    public long addToDoToDb(ToDoItem addable) {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ToDoItemContract.ToDoItem.COLUMN_NAME_TITLE, addable.title);
        values.put(ToDoItemContract.ToDoItem.COLUMN_TODO_DATE, addable.date);
        values.put(ToDoItemContract.ToDoItem.COLUMN_TODO_DESCRIPTION, addable.description);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ToDoItemContract.ToDoItem.TABLE_NAME, null, values);
        db.close();
        return newRowId;


    }
    public ArrayList<ToDoItem> getRecords(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        data=new ArrayList<ToDoItem>();

        Cursor cursor = db.query(ToDoItemContract.ToDoItem.TABLE_NAME,
                new String[]{
                        ToDoItemContract.ToDoItem.COLUMN_ID,
                        ToDoItemContract.ToDoItem.COLUMN_TODO_DATE,
                        ToDoItemContract.ToDoItem.COLUMN_NAME_TITLE,
                        ToDoItemContract.ToDoItem.COLUMN_TODO_DESCRIPTION},
                null,
                null,
                null,
                null,
                null);

        int iid = cursor.getColumnIndex(ToDoItemContract.ToDoItem.COLUMN_ID);
        int idate = cursor.getColumnIndex(ToDoItemContract.ToDoItem.COLUMN_TODO_DATE);
        int ititle = cursor.getColumnIndex(ToDoItemContract.ToDoItem.COLUMN_NAME_TITLE);
        int idesc = cursor.getColumnIndex(ToDoItemContract.ToDoItem.COLUMN_TODO_DESCRIPTION);


        while(cursor.moveToNext()){
            id = cursor.getLong(iid);
            String date = cursor.getString(idate);
            String title = cursor.getString(ititle);
            String descrption = cursor.getString(idesc);
            data.add(new ToDoItem(id, date, title, descrption));
        }
        cursor.close();
        db.close();
        return data;
    }

    public void updateTodo(ToDoItem toDoItem){
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ToDoItem toDoItem1 = toDoItem;
        long id = toDoItem1.getId();
        String columnname = ToDoItemContract.ToDoItem.COLUMN_ID;
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(columnname, id);
        // Insert the new row, returning the primary key value of the new row
        db.update(ToDoItemContract.ToDoItem.TABLE_NAME, values, "_id="+id, null);
        db.close();
    }

    public boolean deleteTodo(long id){
        long idnro = id;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.delete(ToDoItemContract.ToDoItem.TABLE_NAME,  "id="+idnro, null);
        db.close();
        return true;

    }
    public void deleteAll(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.delete(ToDoItemContract.ToDoItem.TABLE_NAME, null, null);
        db.close();

    }




}
