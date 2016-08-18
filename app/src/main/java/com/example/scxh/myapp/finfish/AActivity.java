package com.example.scxh.myapp.finfish;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.scxh.myapp.R;

public class AActivity extends AppCompatActivity {
    String name="com.example.scxh.myapp.CActivity";
    private Button sendBroadBtn;
    private BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_layout);
        Log.e("tag","A ACTIVITY>>>>onCreate");
        sendBroadBtn= (Button) findViewById(R.id.broad_castReciever);
        sendBroadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(AActivity.this,BActivity.class);
                startActivity(intent);
            }
        });
         broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if ((intent.getAction()).equals(name)) {
                    Log.e("tag","aaaaaaaa onReceive ");
                    Toast.makeText(AActivity.this,"A成功退出",Toast.LENGTH_SHORT).show();
                    unRegister();
                    finish();
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        regist();
    }

    public void regist(){
        registerReceiver(broadcastReceiver,new IntentFilter(name));
    }
    public void unRegister(){
        unregisterReceiver(broadcastReceiver);
    }
}
