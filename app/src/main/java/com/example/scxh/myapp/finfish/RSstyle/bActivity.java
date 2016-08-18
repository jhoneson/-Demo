package com.example.scxh.myapp.finfish.RSstyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.scxh.myapp.R;

public class bActivity extends AppCompatActivity {
    private Button buttonTWO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2);
        buttonTWO= (Button) findViewById(R.id.jump_two);
        buttonTWO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bActivity.this,cActivity.class));
            }
        });
    }
}
