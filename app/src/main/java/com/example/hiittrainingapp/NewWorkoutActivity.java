package com.example.hiittrainingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewWorkoutActivity extends AppCompatActivity implements View.OnClickListener {

    boolean Pause = false;
    CheckBox checkBox;
    EditText editor, editorWork;
    String text;
    private int finalPlacedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        findViewById(R.id.addBtn).setOnClickListener(this);
        checkBox = findViewById(R.id.checkbox);
        editor = findViewById(R.id.setTimeEditor);
        editorWork = findViewById(R.id.yourWorkOut);
    }

    public void onCheckBoxClicked(View v){
        if(checkBox.isChecked()){
              Pause = true;
              editorWork.setEnabled(false);
              editorWork.setText("Pause");
        }
        else{
            Pause = false;
            editorWork.setEnabled(true);
            editorWork.setText(null);
        }
    }

    public void getTime(){
        String placedTime = editor.getText().toString();
        finalPlacedTime = Integer.parseInt(placedTime);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.addBtn){

            text = editorWork.getText().toString();
            if(Pause){
                text = "Pause";
                //ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.workListLayout);
                //mLayout.setBackgroundColor(0xFFFF0000);
            }

            getTime();
            if(finalPlacedTime == 0){
                editorWork.setText(null);
                editor.setText(null);
                return;
            }

            WorkOutPart part = new WorkOutPart(finalPlacedTime, text);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("NEW_PART", part);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        }
    }


}
