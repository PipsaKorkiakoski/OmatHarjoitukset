package com.example.externalactivities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setText("Open map");
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setText("Create call");
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setText("GO");

        editText = (EditText)findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.fi/maps/place/Oamk/@64.9994848,25.5096737,17z/data=!3m1!4b1!4m5!3m4!1s0x4681cd452343d31f:0xca6e07c114a9fd6e!8m2!3d64.9994825!4d25.5118677";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:5551234");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url2 = "http://";
                url2 = url2+editText.getText().toString();
                Uri webpage = Uri.parse(url2);
                Intent webintent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webintent);
            }
        });
    }


}
