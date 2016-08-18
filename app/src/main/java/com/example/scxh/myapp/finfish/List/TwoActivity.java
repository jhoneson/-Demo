package com.example.scxh.myapp.finfish.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.scxh.myapp.R;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {
    private Button button;
    public ArrayList<Activity> list=OneActivity.list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        button = (Button) findViewById(R.id.finish_list_two);
       AtyContainer.getInstance().addActivity(this);
        Log.e("tag", "two onCreate=== "+list.size());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("tag", "two onClick ");
                Toast.makeText(TwoActivity.this, "two跳转成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(TwoActivity.this, ThreeActivity.class));
            }
        });
    }
}

