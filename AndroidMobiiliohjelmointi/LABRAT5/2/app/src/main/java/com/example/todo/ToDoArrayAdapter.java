package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.todo.model.ToDoItem;
import com.example.todo.model.ToDoModel;

import java.util.ArrayList;

public class ToDoArrayAdapter extends ArrayAdapter<ToDoItem> {
    static final int VIEW_TYPE_TODO = 0;
    static final int VIEW_TYPE_COUNT = 1;

    public ToDoArrayAdapter(Context context, ArrayList<ToDoItem> todos){
        super(context, 0, todos);


    }
    public int getViewTypeCount(){
        return VIEW_TYPE_COUNT;
    }
    public int getItemViewType(int pos){
        ToDoItem toDoItem = getItem(pos);
        if(toDoItem instanceof ToDoItem){
            return VIEW_TYPE_TODO;
        }
        else{
            return VIEW_TYPE_TODO;
        }
    }
    public View getView(int pos, View convertView, ViewGroup parent){
        ToDoItem toDoItem = getItem(pos);
        if(convertView == null){
            int layoutId = 0;
            if (getItemViewType(pos) == VIEW_TYPE_TODO){
                layoutId = R.layout.list_row_todo;
            }
            convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
        }
        TextView todoname = convertView.findViewById(R.id.todo_name);
        todoname.setText(toDoItem.getTitle());
        TextView tododate = convertView.findViewById(R.id.todo_date);
        tododate.setText(toDoItem.getDate());
        TextView tododescription = convertView.findViewById(R.id.todo_description);
        tododescription.setText(toDoItem.getDescription());
        return convertView;


    }
}
