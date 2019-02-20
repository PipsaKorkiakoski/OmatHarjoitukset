package com.example.pipsa.demoui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.button)
        {
            Henkilo ope = new Henkilo();
            ope.nimi = "Seppo";
            ope.hloTunnus = "1234455-1233";

            Henkilo opiskelija = new Henkilo();
            opiskelija.nimi = "Kari";
            opiskelija.hloTunnus = "23245667-12345";
            Toast.makeText(this, "Nappia painettu!" + ope.getNimi(), Toast.LENGTH_LONG).show();
        }



    }
}
