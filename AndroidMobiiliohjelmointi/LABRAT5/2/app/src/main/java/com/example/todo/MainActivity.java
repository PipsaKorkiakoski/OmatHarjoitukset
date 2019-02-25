package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.todo.model.ToDoItem;
import com.example.todo.model.ToDoModel;
import com.example.todo.model.db.ToDoItemContract;
import com.example.todo.model.db.ToDoItemDbHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ToDoModel model = null;
    ToDoItemDbHelper mDbHelper = null;
    ListView listView = null;
    ArrayList<ToDoItem> todos = new ArrayList<ToDoItem>();
    ToDoItem toDoItem;
    long todoid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.todolista);
        mDbHelper = new ToDoItemDbHelper(this);
        model = new ToDoModel(this);

        //make this always when i start
        String title = "Always when start";
        String description = "Make this always when i start the app";
        String selectedDate = "22/02/2019";
        long id = 0;
        ToDoItem starttodoobject = new ToDoItem(id, selectedDate, title, description );
        id = model.addToDoToDb(starttodoobject);
        starttodoobject.setId(id);
        model.updateTodo(starttodoobject);
        todos = model.getRecords();


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                toDoItem = todos.get(position);

                todoid = toDoItem.getId();
                model.deleteTodo(todoid);
                onResume();
                return false;
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.addnew) {
            Intent intent = new Intent(MainActivity.this, AddNewToDo.class);
            startActivity(intent);
        }
        if (item.getItemId()== R.id.deleteall){
            model.deleteAll();
            onResume();
        }
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        todos = model.getRecords();
        ToDoArrayAdapter adapter = new ToDoArrayAdapter(this, todos);
        listView.setAdapter(adapter);
    }


}
