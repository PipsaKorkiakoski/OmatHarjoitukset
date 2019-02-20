package com.example.menus;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        View view = findViewById(R.id.mylinearlayout);
        View root = view.getRootView();
        TextView teksti = (TextView) findViewById(R.id.tekstikentta);

        if(item.getItemId() == R.id.Red){
            root.setBackgroundColor(Color.RED);
            teksti.setText("RED");
        }
        else if(item.getItemId() == R.id.Green){
            root.setBackgroundColor(Color.GREEN);
            teksti.setText("GREEN");
        }
        else if(item.getItemId() == R.id.Blue){
            root.setBackgroundColor(Color.BLUE);
            teksti.setText("BLUE");
        }
        else if(item.getItemId() == R.id.Yellow){
            root.setBackgroundColor(Color.YELLOW);
            teksti.setText("YELLOW");
        }

        return true;
    }
}
