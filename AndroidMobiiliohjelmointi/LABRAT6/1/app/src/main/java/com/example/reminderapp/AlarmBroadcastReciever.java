package com.example.reminderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("DEMO_6", "onCreate");
        Toast.makeText(context, "AlarmBroadcastReceiver - onReceive", Toast.LENGTH_SHORT).show();

    }
}
