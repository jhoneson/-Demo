package com.example.scxh.myapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetCountActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textView;
    private Button startServiceBtn,StopServiceBtn,startCountBtn,getCountBtn;
    private MyService.ICountService iCountService;
    public ServiceConnection serviceConnection = new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("onserviceConnected >>","2222");
            iCountService= (MyService.ICountService) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_count);
        textView= (TextView) findViewById(R.id.Count_txt);
        startCountBtn= (Button) findViewById(R.id.Count_start_btn);
        getCountBtn= (Button) findViewById(R.id.Count_getCount_btn);
        startServiceBtn= (Button) findViewById(R.id.start_service_btn);
        StopServiceBtn= (Button) findViewById(R.id.stop_service_btn);
        startServiceBtn.setOnClickListener(this);
        StopServiceBtn.setOnClickListener(this);
        startCountBtn.setOnClickListener(this);
        getCountBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service_btn:
                startService();
                break;
            case R.id.Count_getCount_btn:
                getCount();
                break;
            case R.id.stop_service_btn:
                stopService();
                break;
        }
    }
    /*
     *todo 启动服务 绑定服务 既能后台播放，又能和Service交互
     */
    public void startService(){
        Intent intent=new Intent(this,MyService.class);
        startService(intent);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }
    //// TODO: 2016/7/11 停止服务
    public void stopService(){
        Intent intent=new Intent(this,MyService.class);
        iCountService.stop();
        stopService(intent);
    }

  //// TODO: 2016/7/11 获取记数值

    public void getCount(){
        int count=iCountService.getCount();
        textView.setText(String.valueOf(count));
    }

}
