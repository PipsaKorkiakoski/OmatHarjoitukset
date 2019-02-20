package com.example.workout;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.workout.model.Type;
import java.util.ArrayList;


public class Timer extends AppCompatActivity {

    TextView typeview;
    TextView secondsView;
    int time;
    int currentIndex = 0;
    String typeName;
    ArrayList<Type> types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        typeview = findViewById(R.id.typeView);
        secondsView = findViewById(R.id.secondLeftView);
        types  = (ArrayList<Type>) getIntent().getSerializableExtra("TYPES");
        startTimer(types.get(currentIndex));
        Type type = types.get(currentIndex);

    }
    private void startTimer(Type type) {
        final Type current = types.get(currentIndex);
        CountDownTimer countDownTimer = new CountDownTimer(current.getSeconds()*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                typeview.setText(current.getType());
                secondsView.setText("" + millisUntilFinished/1000);
            }
            @Override
            public void onFinish() {
                typeview.setText("Done!");
                currentIndex++;
                if(currentIndex < types.size())
                {
                    startTimer(types.get(currentIndex));

                }
                else{
                    finish();
                }
            }
        }.start();

    }


}
