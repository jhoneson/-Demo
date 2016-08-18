package com.example.scxh.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TransportActivity extends AppCompatActivity {
    public TextView mTextView;
    private Handler mhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_layout);

        mTextView= (TextView) findViewById(R.id.tansport_txt);

        // TODO: 2016/6/13 主线程里处理消息
        mhandler=new Handler(){
            public void handleMessage(Message msg) {
                int type = msg.arg1;                // TODO: 2016/6/13 标识识别
                switch (type){
                    case 0:
                        Intent intent = new Intent(TransportActivity.this, MainLayoutActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        String count = (String) msg.obj;
                        mTextView.setText(count);
                        break;
                }

            }
        };

        // TODO: 2016/6/13 在子线程里发送消息
        Message message = Message.obtain();
        message.arg1=0;    // TODO: 2016/6/13 标识1
        mhandler.sendMessageDelayed(message,4000);
        new Thread(new Runnable() {
            int i;
            @Override
            public void run() {
                for(i=4;i>0;i--){
                    Message message = Message.obtain();
                    message.arg1=1;        // TODO: 2016/6/13 标识2
                    message.obj=i+"";
                    mhandler.sendMessage(message);
                    SystemClock.sleep(1000);
                }
            }
        }).start();
    }
}
