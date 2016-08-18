package com.example.scxh.myapp.finfish.RSstyle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.scxh.myapp.R;

public class cActivity extends AppCompatActivity {
    private Button buttonThreeBtn;
    private String name="com.android1601";
    private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2);
        buttonThreeBtn= (Button) findViewById(R.id.jump_three);
        buttonThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadCast();
                startActivity(new Intent(cActivity.this,aActivity.class));
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        register();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregister();
    }

    public void register(){
        registerReceiver(broadcastReceiver,new IntentFilter(name));
    }
    public void sendBroadCast(){
        sendBroadcast(new Intent(name));
    }
    public void unregister(){
        unregisterReceiver(broadcastReceiver);
    }
}
