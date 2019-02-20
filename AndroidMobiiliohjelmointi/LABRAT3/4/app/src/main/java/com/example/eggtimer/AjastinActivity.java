package com.example.eggtimer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AjastinActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajastin);
        String aika = getIntent().getStringExtra("aika");

        int time = Integer.parseInt(aika);
        time = time*1000;


        textView = findViewById(R.id.textView2);
        CountDownTimer countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                textView.setText("Done!");
                Intent intent = new Intent(AjastinActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}
