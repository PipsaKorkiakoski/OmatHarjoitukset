package com.example.uinappi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int muuttuja = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final Button gameButton = new Button(this);
        gameButton.setText("Hello, I'm the button");

        setContentView(gameButton);
        gameButton.setText("Paina pelinappulaa!");

        gameButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                muuttuja += 1;
                gameButton.setText("Painoit " + muuttuja + " kertaa");
            }
        });


    }
}
