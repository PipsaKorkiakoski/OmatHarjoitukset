package com.example.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Time;

public class TimerActivity extends AppCompatActivity {

    TextView textView;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        String aika = getIntent().getStringExtra("aika");
        Integer time = aika.compareTo(aika);
        textView = findViewById(R.id.textView2);
        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText((int) (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                textView.setText("Done!");
            }
        }.start();

    }

}
