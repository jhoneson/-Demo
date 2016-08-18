package com.example.scxh.myapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity {
    public ProgressBar PprogressBar;
    public Handler handler;
    public TextView mTextView;
    public Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_layout);

        PprogressBar = (ProgressBar) findViewById(R.id.progress_a);
        mButton = (Button) findViewById(R.id.progress_btn);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String str = (String) msg.obj;
                Toast.makeText(ProgressBarActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        };

    }

    public void progressBtn(View v) {
        startProgressThread();
    }

    public void startProgressThread() {
        PprogressBar.setMax(200);
        new Thread(new Runnable() {
                @Override
            public void run() {
                for (int i = 10; i < 200; i++) {
                    PprogressBar.setProgress(i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    Message msg = Message.obtain();
                    msg.obj = "加载完成!";
                    handler.sendMessage(msg);
                    finish();
            }

        }).start();

    }
}