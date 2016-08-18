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

public class CActivity extends AppCompatActivity {
    private Button button;
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("tag","ccccccccccc onReceive ");
            unRegister();
            Toast.makeText(CActivity.this,"C成功退出",Toast.LENGTH_SHORT).show();
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        button= (Button) findViewById(R.id.broad_castReciever_c);
        Log.e("tag","ccccccccccc onCreate ");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("tag","ccccccccccc onClick ");
                senBroad();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        regist();
    }

    public void regist(){
        registerReceiver(broadcastReceiver,new IntentFilter("com.example.scxh.myapp.CActivity"));
    }
    public void senBroad(){
        sendBroadcast(new Intent("com.example.scxh.myapp.CActivity"));
    }
    public void unRegister(){
        unregisterReceiver(broadcastReceiver);
    }
}
