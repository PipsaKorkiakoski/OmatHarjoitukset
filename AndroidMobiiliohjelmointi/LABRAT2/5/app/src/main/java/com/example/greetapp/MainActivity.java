package com.example.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText3);
        textView = findViewById(R.id.textView2);

        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
    }

    public String haeteksti(){
        String teksti = editText.getText().toString();

        return teksti;
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button5){
            //Suomeksi
            textView.setText("Heippa " + haeteksti());
            editText.setText(null);
        }
        else if(view.getId() == R.id.button6){
            textView.setText("Hejsan " + haeteksti());
            editText.setText(null);
        }
        else if(view.getId() == R.id.button7){
            textView.setText("Hello " + haeteksti());
            editText.setText(null);
        }
        else if(view.getId() == R.id.button8){
            textView.setText("Hai hitler!");
            editText.setText(null);
        }
    }
}
