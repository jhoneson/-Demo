package com.example.scxh.myapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyBroadcastActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startBtn, DTbroadCastRecieverBttn,localBroadcastBtn;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "收到动态广播消息", Toast.LENGTH_SHORT).show();
        }
    };
    private BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "收到本地广播消息", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_broadcast);
        startBtn = (Button) findViewById(R.id.broad);
        DTbroadCastRecieverBttn = (Button) findViewById(R.id.DTbroad);
        localBroadcastBtn= (Button) findViewById(R.id.local_broad);
        DTbroadCastRecieverBttn.setOnClickListener(this);
        startBtn.setOnClickListener(this);
        localBroadcastBtn.setOnClickListener(this);
    }
    //注册区域
    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcastReciever();
        registrLocalBroad();
    }
    //发送普通广播
    public void sendMessage() {
        Intent intent = new Intent("com.example.scxh.myBroadcasrReciever");
        sendBroadcast(intent);
    }
    //发送本地广播
    public void SendLocalmsg(){
        Intent intent=new Intent("com.example.scxh.LocalBroadCastReciever");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.broad:
                sendMessage();
                break;
            case R.id.DTbroad:
                SendDTmsg();
                break;
            case R.id.local_broad:
                SendLocalmsg();
                break;
        }
    }
    /*
     *发送动态广播
     */
    public void SendDTmsg(){
        sendBroadcast(new Intent("com.example.scxh.DTreciever"));
    }
    /*
     *注册动态广播
     */
    public void registerBroadcastReciever(){
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.scxh.DTreciever");
        registerReceiver(broadcastReceiver,intentFilter);
    }
    /*
     *注册本地广播
     */
    public void registrLocalBroad(){
        IntentFilter intentFilter=new IntentFilter("com.example.scxh.LocalBroadCastReciever");
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,intentFilter);
    }
   /*
    *注销广播
    */
    @Override
    protected void onPause() {
        super.onPause();
        if(broadcastReceiver != null) {
            UnregisterBS();
            UnregisterLocalBS();
        }
    }
    /*
     * 注销本地广播
     */
    public void UnregisterLocalBS(){
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }
    /*
    * 注销动态广播
    */
    public void UnregisterBS(){
        unregisterReceiver(broadcastReceiver);
    }
}
