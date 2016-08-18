package com.example.scxh.myapp.finfish.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.scxh.myapp.R;

public class ThreeActivity extends AppCompatActivity {
    private Button button;
    ThreeActivity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        button= (Button) findViewById(R.id.finish_list_three);
        activity=new ThreeActivity();
       AtyContainer.getInstance().addActivity(this);
        Log.e("tag","ccccccccccc onCreate==== "+OneActivity.list.size());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("tag","ccccccccccc onClick ");
               AtyContainer.getInstance().FinishAllActivity();
            }
        });
    }

}
