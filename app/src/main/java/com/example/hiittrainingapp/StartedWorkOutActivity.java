package com.example.hiittrainingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;

import java.io.Serializable;
import java.util.ArrayList;

public class StartedWorkOutActivity extends AppCompatActivity implements Serializable, TextToSpeech.OnInitListener {

    int i = 0;
    ArrayList<WorkOutPart> fullWorkOut;
    TextToSpeech tts;
    TextView workOutText, timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_work_out);

        tts = new TextToSpeech(this, this);
        workOutText = findViewById(R.id.whatIsYourWorkOut);
        timeText = findViewById(R.id.timeLeftOnWorkOut);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("fullWorkout");
        fullWorkOut = (ArrayList<WorkOutPart>) bundle.getSerializable("bundle");

        myTimer();
    }

    public void myTimer(){

        workOutText.setText(fullWorkOut.get(i).getName());
        int fixedTime = (fullWorkOut.get(i).getSeconds() * 1000);

        CountDownTimer timer = new CountDownTimer(fixedTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("" + (millisUntilFinished / 1000));
                String aika = String.valueOf(millisUntilFinished / 1000);
                tts.speak(aika, TextToSpeech.QUEUE_FLUSH, null);
            }

            @Override
            public void onFinish() {

                /*if(fullWorkOut.get(i).getSeconds() == 0) {
                    finish();
                }*/
                i++;
                if(i < fullWorkOut.size()){
                    myTimer();
                }
                else {
                    //fullWorkOut.clear();
                    finish();
                }
                //if(fullWorkOut.get(i).getSeconds() == 0)


            }
        }.start();
    }

    @Override
    public void onInit(int status) {

    }
}
