package com.example.workout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.example.workout.model.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static final int ADD_WORK_ID = 111;
    static final String SPF = "MyApp";
    static final String SPETK = "textInTheEditor";

    private String typeName;
    private int secondsLeft;
    ArrayList<Type> types = new ArrayList<Type>();
    ListView listView = null;
    Type type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startWorkBtn).setOnClickListener(this);
        listView = findViewById(R.id.listview);
        getTasksFromSharedPrefs(this);

    }
    protected void onResume() {
        super.onResume();
        TypeArrayAdapter adapter = new TypeArrayAdapter(this, types);
        listView.setAdapter(adapter);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.New){
            Intent intent = new Intent(this, AddNewPart.class);
            startActivityForResult(intent, ADD_WORK_ID);
        }
        else if(item.getItemId()==R.id.ClearAll){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //clear
                    types.clear();
                    saveArrayList(types,"TYPES");
                    onResume();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setMessage("Are you sure?");
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(item.getItemId()==R.id.SaveAll){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                saveArrayList(types, "TYPES" );
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setMessage("Are you sure?");
            AlertDialog alert = builder.create();
            alert.show();
        }
        return true;
    }
    public void saveArrayList(ArrayList<Type> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public List<Type> getTasksFromSharedPrefs(Context context) {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        Gson gson = new Gson();
        String json = appSharedPrefs.getString("TYPES", "");
        types = gson.fromJson(json, new TypeToken<ArrayList<Type>>(){}.getType());
        return types;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_WORK_ID && resultCode == RESULT_OK){
            type = (Type) data.getSerializableExtra("TYPE");
            secondsLeft = type.getSeconds();
            typeName = type.getType();
            types.add(type);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Timer.class);
        intent.putExtra("TYPES", types);
        startActivity(intent);
    }



}

