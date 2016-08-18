package com.example.scxh.myapp.finfish.result;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.scxh.myapp.R;

public class ThirdActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button= (Button) findViewById(R.id.third_activity);
        Toast.makeText(this,"3跳转成功",Toast.LENGTH_SHORT).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baskMsg="耗子耗子，我是田鼠，收到请回答";
                Intent data = getIntent();
                data.putExtra("MESSAGE",baskMsg);
                setResult(202,data);
                finish();
            }
        });
    }
}
