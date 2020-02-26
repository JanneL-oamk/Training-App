package com.example.hiittrainingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Serializable {

    int ADD_NEW_PART_INTENT_ID = 8976;
    ArrayList<WorkOutPart> fullWorkOut = new ArrayList<>();

    private ListView listView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.startBtn).setOnClickListener(this);

        listView = (ListView) findViewById(R.id.workOutList);
        mAdapter = new MyAdapter(this, R.layout.list_row_workout, fullWorkOut);
        listView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_NEW_PART_INTENT_ID && resultCode == Activity.RESULT_OK){
            WorkOutPart newPart =(WorkOutPart) data.getSerializableExtra("NEW_PART");

            fullWorkOut.add(newPart);
            //mAd   apter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.newBtn:
                Intent addWorkOutIntent = new Intent(MainActivity.this, NewWorkoutActivity.class);
                startActivityForResult(addWorkOutIntent, ADD_NEW_PART_INTENT_ID);

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.startBtn){
            Intent startedWorkOutIntent = new Intent(MainActivity.this, StartedWorkOutActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("bundle", fullWorkOut);
            startedWorkOutIntent.putExtra("fullWorkout", bundle);

            startActivity(startedWorkOutIntent);
        }
    }
}
