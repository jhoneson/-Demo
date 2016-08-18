package com.example.scxh.myapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServletActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textView;
    private Button button;
    private HttpURLConnection httpURLConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servlet);
        textView= (TextView) findViewById(R.id.servlet_txt);
        button= (Button) findViewById(R.id.servlet_btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.servlet_btn:
                doDownLoadTxt();
                break;
        }
    }
    public void doDownLoadTxt(){
        final String netUrl="http://192.168.5.3/webroot/around";
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... params) {
                String text=params[0];
                return doGetByNet(text);
            }

            @Override
            protected void onPostExecute(String s) {
               textView.setText(s);
            }
        }.execute(netUrl);
    }
    public String doGetByNet(String httpurl){
        String msg="";
        try {
            URL url=new URL(httpurl);
            httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            int code=httpURLConnection.getResponseCode();
            Log.e("2222222","code"+code);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.connect();
            InputStream is=httpURLConnection.getInputStream();
            msg=readInput(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return msg;
    }
    public String readInput(InputStream in){
        Reader reader=new InputStreamReader(in);
        BufferedReader br=new BufferedReader(reader);
        StringBuilder builder=new StringBuilder();
        String line="";
        try {
            while((line=br.readLine()) != null){
                builder.append(line);  //在builder中保存数据
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
}
