package com.example.zoo;

import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    ImageView ivm1, ivm2, ivm3, ivm4, ivb1, ivb2, ivb3, ivb4;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivm1 = findViewById(R.id.mammal1);
        ivm1.setOnTouchListener(this);
        ivm2 =findViewById(R.id.mammal2);
        ivm2.setOnTouchListener(this);
        ivm3=findViewById(R.id.mammal3);
        ivm3.setOnTouchListener(this);
        ivm4 = findViewById(R.id.mammal4);
        ivm4.setOnTouchListener(this);
        ivb1 = findViewById(R.id.bird1);
        ivb1.setOnTouchListener(this);
        ivb2 = findViewById(R.id.bird2);
        ivb2.setOnTouchListener(this);
        ivb3 = findViewById(R.id.bird3);
        ivb3.setOnTouchListener(this);
        ivb4 = findViewById(R.id.bird4);
        ivb4.setOnTouchListener(this);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.mammals){
            ivb1.setVisibility(View.INVISIBLE);
            ivb2.setVisibility(View.INVISIBLE);
            ivb3.setVisibility(View.INVISIBLE);
            ivb4.setVisibility(View.INVISIBLE);
            ivb1.setVisibility(View.INVISIBLE);
            ivb2.setVisibility(View.INVISIBLE);
            ivb3.setVisibility(View.INVISIBLE);
            ivb4.setVisibility(View.INVISIBLE);

        }
        else if(item.getItemId() == R.id.birds){

        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v.getId() == R.id.mammal1){
            mediaPlayer = MediaPlayer.create(this, R.raw.bear);
            mediaPlayer.start();
        }
        else if(v.getId() == R.id.mammal2){
            mediaPlayer = MediaPlayer.create(this, R.raw.elephant);
            mediaPlayer.start();
        }
        else if(v.getId() == R.id.mammal3){
            mediaPlayer = MediaPlayer.create(this, R.raw.lamb);
            mediaPlayer.start();
        }
        else if(v.getId() == R.id.mammal4){
            mediaPlayer = MediaPlayer.create(this, R.raw.wolf);
            mediaPlayer.start();
        }
        else if(v.getId() == R.id.bird1){
            mediaPlayer = MediaPlayer.create(this, R.raw.huuhkaja_norther_eagle_owl);
            mediaPlayer.start();
        }
        else if(v.getId() == R.id.bird2){
            mediaPlayer = MediaPlayer.create(this, R.raw.peippo_chaffinch);
            mediaPlayer.start();
        }
        else if(v.getId() == R.id.bird3){
            mediaPlayer = MediaPlayer.create(this, R.raw.peukaloinen_wren);
            mediaPlayer.start();
        }
        else if(v.getId() == R.id.bird4){
            mediaPlayer = MediaPlayer.create(this, R.raw.punatulkku_northern_bullfinch);
            mediaPlayer.start();
        }
        return false;
    }
}
