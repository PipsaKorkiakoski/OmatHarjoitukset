package com.example.reminderapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    NumberPicker numberPicker1, numberPicker2;
    EditText editText;
    int hour, minute;
    String editTextValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);


        numberPicker1 = findViewById(R.id.numberPicker);
        numberPicker1.setMinValue(00);
        numberPicker1.setMaxValue(23);
        numberPicker1.setOnValueChangedListener(onValueChangeListener);

        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker2.setMinValue(00);
        numberPicker2.setMaxValue(59);
        numberPicker2.setOnValueChangedListener(onValueChangeListener2);


        findViewById(R.id.donebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextValue = editText.getText().toString();
                Toast.makeText(MainActivity.this, "Exception: ", Toast.LENGTH_LONG).show();
                showNotification();
                broadcastDemo();
                finish();
            }
        });


    }

    NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            hour = newVal;
        }
    };

    NumberPicker.OnValueChangeListener onValueChangeListener2 = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            minute = newVal;
        }
    };



    protected void onStop() {
        super.onStop();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    protected void showNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, RemainderApplication.CHANNEL_ID)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle(""+editText.getText().toString())
                .setContentText(""+hour+":"+minute)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(234, mBuilder.build());
    }

    protected void broadcastDemo() {
        AlarmManager alarmMgr;
        PendingIntent alarmIntent;

        alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmBroadcastReciever.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() +
                        30 * 1000, alarmIntent);

    }

}
