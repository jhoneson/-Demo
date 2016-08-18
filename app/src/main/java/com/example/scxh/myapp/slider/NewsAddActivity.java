package com.example.scxh.myapp.slider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.scxh.myapp.R;
import com.warmtel.slidingmenu.lib.SlidingMenu;
import com.warmtel.slidingmenu.lib.app.SlidingActivity;

public class NewsAddActivity extends SlidingActivity implements NewsFragment.OnClickLisenler{
    SlidingMenu slidingMenu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsadd);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.news_frame_layout,TestNewsFragmen.newInstance())
                .commit();

        setBehindContentView(R.layout.sliding_menu_layout);                  //工具包里的布局，不可更改
        getSupportFragmentManager().beginTransaction()
                .add(R.id.sliding_menu_layout,NewsFragment.newInstance())    //工具包里的布局的ID，不可更改
                .commit();
        slidingMenu=getSlidingMenu();
        slidingMenu.setSlidingEnabled(true);                              //设置可以划出
        slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_off_width);   //可以划开的最大角度
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);      //从边上开始划
        slidingMenu.setMode(SlidingMenu.LEFT);                            //从左侧划出
    }

    @Override
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.video_txt:
            Toast.makeText(this, "视频跳转成功", Toast.LENGTH_SHORT).show();
                break;
        }
        slidingMenu.toggle();
    }

}
