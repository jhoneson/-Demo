package com.example.scxh.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HttpDownloadActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_download);
        imageView= (ImageView) findViewById(R.id.http_pic);
        button= (Button) findViewById(R.id.http_getpic_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask downloadTask=new DownloadTask(HttpDownloadActivity.this);
                downloadTask.execute("http:///xx/xx/xxx.jpg");
            }
        });

    }
}
