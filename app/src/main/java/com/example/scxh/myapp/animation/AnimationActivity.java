package com.example.scxh.myapp.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.scxh.myapp.R;

public class AnimationActivity extends AppCompatActivity {
    private Button animationBtn;
    private TextView animatorTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_layout);
        animationBtn= (Button) findViewById(R.id.animation_btn);
        animatorTxt= (TextView) findViewById(R.id.animation_txt);
        animationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=v.getId();
                if(i==R.id.animation_btn) {
                    ObjectAnimator rotation=ObjectAnimator.ofFloat(animatorTxt,"rotation",0,360);  //旋转
                    ObjectAnimator alpha=ObjectAnimator.ofFloat(animatorTxt,"alpha",1f,0f,1f);   //淡入淡出
                    alpha.setDuration(4000);
                    float translationX = animatorTxt.getTranslationX();
                    ObjectAnimator translation=ObjectAnimator.ofFloat(animatorTxt,"translationX",translationX,-500f,500f,translationX); //todo 平移
                    translation.setDuration(4000);
                    ObjectAnimator scale = ObjectAnimator.ofFloat(animatorTxt,"scaleY",1f,3f,1f);  //缩放
                    scale.setDuration(5000);
                    AnimatorSet animatorSet=new AnimatorSet();
                    animatorSet.play(alpha).with(translation).after(scale).with(rotation);
                    animatorSet.start();
                }
            }
        });
    }
}
