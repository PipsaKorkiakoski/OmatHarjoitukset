package com.example.uinolayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText editText;
    Button addBtn;
    Button editBtn;
    Button removeBtn;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        final String[] COUNTRIES = new String[]{
          "Afganistan", "Albania", "Algeria", "American Samoa"
        };

        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
        editText = new EditText(this);
        linearLayout.addView(editText);
        addBtn = new Button(this);
        addBtn.setText("Add");
        linearLayout.addView(addBtn);
        editBtn = new Button(this);
        editBtn.setText("Edit");
        linearLayout.addView(editBtn);
        removeBtn = new Button(this);
        removeBtn.setText("Remove");
        linearLayout.addView(removeBtn);
        listView = new ListView(this);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1 ,COUNTRIES);
        listView.setAdapter(aa);
        linearLayout.addView(listView);






    }}
