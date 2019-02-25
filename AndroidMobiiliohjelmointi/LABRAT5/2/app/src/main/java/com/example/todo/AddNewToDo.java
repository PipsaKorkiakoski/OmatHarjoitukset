package com.example.todo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.todo.model.ToDoItem;
import com.example.todo.model.ToDoModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNewToDo extends AppCompatActivity {

    ToDoModel model = null;

    EditText titleEdit;
    EditText descriptionEdit;
    CalendarView calendarView;
    String newDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_to_do);

        model = new ToDoModel(this);
        titleEdit = findViewById(R.id.titleEdit);
        descriptionEdit = findViewById(R.id.descriptionEdit);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                newDate = year+"-"+(month+1)+"-"+dayOfMonth;
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save) {
            String title = titleEdit.getText().toString();
            String description = descriptionEdit.getText().toString();
            long id = 0;
            ToDoItem todoitem1 = new ToDoItem(id, newDate,title, description );
            id = model.addToDoToDb(todoitem1);
            todoitem1.setId(id);
            model.updateTodo(todoitem1);
            finish();
        }
        return true;
    }
}
