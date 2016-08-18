package com.example.scxh.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

public class TabActivity extends android.app.TabActivity {
    private TabHost mtabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        mtabHost=getTabHost();  //获取tabHost
        /*
         * 解析布局
         */
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.item_tablayout,null);
        View v1=inflater.inflate(R.layout.item2_tablayout,null);
        View v2=inflater.inflate(R.layout.item3_tablayout,null);

        TabHost.TabSpec tabSpec1=mtabHost.newTabSpec("tab1");
        tabSpec1.setIndicator(v);
        tabSpec1.setContent(new Intent(this,DialogActivity.class));

        TabHost.TabSpec tabSpec2=mtabHost.newTabSpec("tab2");
        tabSpec2.setIndicator(v1);
        tabSpec2.setContent(new Intent(this,ProgressBarActivity.class));

        TabHost.TabSpec tabSpec3=mtabHost.newTabSpec("tab3");
        tabSpec3.setIndicator(v2);
        tabSpec3.setContent(new Intent(this,ToolBarActivity.class));

        mtabHost.addTab(tabSpec1);
        mtabHost.addTab(tabSpec2);
        mtabHost.addTab(tabSpec3);

    }
}
