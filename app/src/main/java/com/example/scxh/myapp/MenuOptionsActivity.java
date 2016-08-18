package com.example.scxh.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;

public class MenuOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_options_layout);
        setOverFlowShowingAlways();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(1,101,1,"联系人");
        menu.add(1,101,2,"短信");

        return super.onCreateOptionsMenu(menu);
    }

    /**
     *实现手机硬件有菜单Menu键也作为ActionBar动作条形式显示
     */
    private void setOverFlowShowingAlways() {
        ViewConfiguration config = new ViewConfiguration().get(this);
        Field menuKeyField = null;
        try {
            menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");

            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
