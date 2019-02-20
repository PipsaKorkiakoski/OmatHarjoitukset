package com.example.uilista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String[] COUNTRIES = new String[]{
                "Afganistan", "Albania", "Algeria", "American Samoa"
        };
        ListView myListView = (ListView) findViewById(R.id.country_list_view);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        myListView.setAdapter(aa);
    }
}
