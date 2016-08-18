package com.example.scxh.myapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.scxh.myapp.bitmaps.BitMapUtils;

public class bigPictureActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button button,localbtn;
    private Handler mHandler = new Handler();
    private Bitmap bitmap;
    private String httpUrl = "http://bz55.com/uploads/allimg/150730/140-150I0163504.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_picture);
        imageView = (ImageView) findViewById(R.id.bitmap_image);
        button = (Button) findViewById(R.id.bitmap_get_btn);
        localbtn= (Button) findViewById(R.id.bitmap_local_get_btn);
        localbtn.setOnClickListener(this);
        button.setOnClickListener(this);

    }
        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.bitmap_get_btn:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            bitmap = BitMapUtils.HttpdecodeSampleBitmapFromStream(httpUrl, 300, 300);
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                        }
                    }).start();
                    break;
                case R.id.bitmap_local_get_btn:
                    bitmap=bitMapUtils.decodeSampledBitmapFromResource(getResources(),R.mipmap.m001,300,300);
                    imageView.setImageBitmap(bitmap);
                    break;
            }
        }
    }

