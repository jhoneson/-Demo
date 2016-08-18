package com.example.scxh.myapp.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.scxh.myapp.R;

public class XmlAnimaterActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_animater);
        textView= (TextView) findViewById(R.id.xml_txt);
        button= (Button) findViewById(R.id.xml_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator= AnimatorInflater.loadAnimator(XmlAnimaterActivity.this,R.animator.animator_set);
                animator.setTarget(textView);
                animator.start();
            }
        });
    }
}
