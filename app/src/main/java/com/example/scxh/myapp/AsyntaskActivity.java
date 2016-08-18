package com.example.scxh.myapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyntaskActivity extends AppCompatActivity implements View.OnClickListener{
    private Button getHttpBtn;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyntask);
        getHttpBtn= (Button) findViewById(R.id.getBtn);
        imageView= (ImageView) findViewById(R.id.image_bitmap);
        getHttpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.getBtn:
                getHttpPICbyAsyn();
                break;
        }
    }
    public void getHttpPICbyAsyn(){
        String httpPath="http://p4.so.qhimg.com/sdr/600_900_/t015d0367e8103fde19.jpg";
        AsyncTask<String,Integer,Bitmap> asyncTask=new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... params) {
                Log.e("1111111","doInBackground>>>>>>>>>>>>");
                return getHttpBitmap(params[0]);
            }

            @Override
            protected void onPostExecute(Bitmap o) {
                Log.e("2222222222","onPostExecute>>>>>>>>>>>>");
                imageView.setImageBitmap(o);

            }
        };
        Log.e("3333333333333","execute>>>>>>>>>>>>");
        asyncTask.execute(httpPath);
    }
    public Bitmap getHttpBitmap(String httpUrl){
        URL url=null;
        Bitmap bitmap=null;
        try {
            url=new URL(httpUrl);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            InputStream is=connection.getInputStream();
            bitmap= BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
