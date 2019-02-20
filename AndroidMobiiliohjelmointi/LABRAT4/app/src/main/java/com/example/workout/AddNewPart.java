package com.example.workout;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.workout.model.Pause;
import com.example.workout.model.Type;
import com.example.workout.model.Workout;

public class AddNewPart extends AppCompatActivity{

    RadioGroup radioGroup;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_part);
        radioGroup = findViewById(R.id.radiobuttongroup);
        editText =findViewById(R.id.editSeconds);
        button = findViewById(R.id.btnAdd);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seconds = Integer.parseInt(editText.getText().toString());
                if(radioGroup.getCheckedRadioButtonId() == findViewById(R.id.radiobtnwork).getId()){
                    Workout workout = new Workout();
                    workout.setType("Workout");
                    workout.setSeconds(seconds);
                    returnData(workout);
                }
                else {
                    Pause pause = new Pause();
                    pause.setType("Pause");
                    pause.setSeconds(seconds);
                    returnData(pause);


                }
            }
        });
    }
    private void returnData(Type data){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("TYPE", data);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }






}
