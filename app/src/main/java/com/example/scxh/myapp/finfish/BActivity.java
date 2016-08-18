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

public class BActivity extends AppCompatActivity {
    private Button button;
    private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("tag","bbbbbb onReceive ");
            Toast.makeText(BActivity.this,"B成功退出",Toast.LENGTH_SHORT).show();
            unRegister();
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        button= (Button) findViewById(R.id.broad_castReciever_b);
        Log.e("tag","bbbbbb onCreate ");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("tag","bbbbbb onClick ");
                Toast.makeText(BActivity.this,"B跳转成功",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BActivity.this,CActivity.class));
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
    public void unRegister(){
        unregisterReceiver(broadcastReceiver);
    }
}
