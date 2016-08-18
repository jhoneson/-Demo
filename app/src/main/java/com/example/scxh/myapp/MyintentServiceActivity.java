package com.example.scxh.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyintentServiceActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myintent_service);
        button= (Button) findViewById(R.id.startBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.startBtn:
                        startDownload();
                        break;
                }
            }
        });


        //todo 可以启动多次，每启动一次，就会新建一个work thread，但IntentService的实例始终只有一个
        //todo Operation 1
        Intent startServiceIntent = new Intent("com.example.scxh.myapp");
        Bundle bundle = new Bundle();
        bundle.putString("param", "oper1");
        startServiceIntent.putExtras(bundle);
        startService(startServiceIntent);
        Log.e("任务1","11111");

        //todo Operation 2
        Intent startServiceIntent2 = new Intent("com.example.scxh.myapp");
        Bundle bundle2 = new Bundle();
        bundle2.putString("param", "oper2");
        startServiceIntent2.putExtras(bundle2);
        startService(startServiceIntent2);
        Log.e("任务2","22222222222");
    }
    public void startDownload (){
        Intent intent=new Intent(this,MyIntentService.class);
        startService(intent);
    }
}
