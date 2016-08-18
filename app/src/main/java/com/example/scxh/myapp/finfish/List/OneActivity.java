package com.example.scxh.myapp.finfish.List;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.scxh.myapp.R;

import java.util.ArrayList;

public class OneActivity extends AppCompatActivity {
    public static ArrayList<Activity> list=new ArrayList<>();
    private Button sendBroadBtn;
    private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_layout);
        AtyContainer.getInstance().addActivity(this);
        Log.e("tag","A ACTIVITY>>>>onCreate==="+list.size());
        sendBroadBtn= (Button) findViewById(R.id.finish_list_one);
        sendBroadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(OneActivity.this,TwoActivity.class);
                startActivity(intent);
            }
        });

    }

}
