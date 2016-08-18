package com.example.scxh.myapp.finfish.result;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.scxh.myapp.R;

public class TwoActivity extends AppCompatActivity {
    private Button button;
    int code=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two2);
        Toast.makeText(this,"2跳转成功",Toast.LENGTH_SHORT).show();
        button= (Button) findViewById(R.id.two_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baskMsg="土豆土豆，我是番茄，收到请回答";
                Intent data = getIntent();
                data.putExtra("MESSAGE",baskMsg);
                setResult(code,data);

                startActivityForResult(new Intent(TwoActivity.this,ThirdActivity.class),202);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String msg=data.getStringExtra("MESSAGE");
        Log.e("requestCode>>"+requestCode," MESSAGE>>"+msg);
        SystemClock.sleep(2000);
        finish();
    }
}
