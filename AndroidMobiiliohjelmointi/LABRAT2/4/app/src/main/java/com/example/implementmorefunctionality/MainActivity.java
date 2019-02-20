package com.example.implementmorefunctionality;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> COUNTRIES = new ArrayList<String>();
    ListView lv;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addbtn).setOnClickListener(this);
        findViewById(R.id.editbtn).setOnClickListener(this);
        findViewById(R.id.deletebtn).setOnClickListener(this);

        editText = findViewById(R.id.editText);
        lv = (ListView) findViewById(R.id.listView);
    }

    private String getTextFieldText() {
        String teksti = editText.getText().toString();
        editText.setText(null);
        return teksti;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.addbtn){
            String kaupunki = getTextFieldText();
            COUNTRIES.add(kaupunki);
            paivita();
        }
        else if(view.getId() == R.id.editbtn){
            haeitem();
        }
        else if(view.getId() == R.id.deletebtn){
            poistaitem();
        }
    }
    public void paivita(){
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        lv.setAdapter(aa);

    }
    public void haeitem(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                editText.setText(selectedItem);
                COUNTRIES.remove(position);
                paivita();
            }
        });
    }
    public void poistaitem(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                COUNTRIES.remove(position);
                paivita();
            }
        });
    }



}
