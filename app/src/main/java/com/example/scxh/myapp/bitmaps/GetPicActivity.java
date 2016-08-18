package com.example.scxh.myapp.bitmaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.scxh.myapp.R;

import java.util.HashMap;

public class GetPicActivity extends AppCompatActivity {
    private Button mButton;
    private TextView textView;
    String httpUrl="http://192.168.5.3/webroot/around";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pic);

        mButton= (Button) findViewById(R.id.until_btn);
        textView= (TextView) findViewById(R.id.until_txt);
        final httpConnectionUtils utils=new httpConnectionUtils();
        Log.e("111","99999999999");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> HashMap=new HashMap<>();
                HashMap.put("userName","张三");
                HashMap.put("passWord","123456");
                Log.e("1111111111","");
                utils.asyncConnection(httpUrl, HashMap, httpConnectionUtils.Method.Get, new httpConnectionUtils.HttpConnectionInterface() {
                    @Override
                    public void excute(String content) {
                        Log.e("2222222222","");
                        Log.e("000000000000","content:"+content);
                        textView.setText(content);
                        Log.e("33333333333","");
                    }
                });
            }
        });
    }
}
