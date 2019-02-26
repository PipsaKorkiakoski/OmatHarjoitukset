package com.example.reminderapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        RemainderApplication app = RemainderApplication.getInstance();
        TextAppModel model = app.getModel();
        String storedText = model.getText();
        TextView text = findViewById(R.id.other_text_field);
        text.setText(storedText);

        findViewById(R.id.show_notification_button).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
        findViewById(R.id.broadcast_demo).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                broadcastDemo();
            }
        });
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
    protected void showNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, RemainderApplication.CHANNEL_ID)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Notification title")
                .setContentText("This is my notification content text. Very awesome!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(234, mBuilder.build());
    }
}
