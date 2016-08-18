package com.example.scxh.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

public class MeituanActivity extends android.app.TabActivity {
    private TabHost mTabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meituan_layout);

        mTabHost=getTabHost();

        LayoutInflater layoutInflater=LayoutInflater.from(this);
        View v=layoutInflater.inflate(R.layout.meiyian_item1_layout,null);
        View v1=layoutInflater.inflate(R.layout.item2_tablayout,null);
        View v2=layoutInflater.inflate(R.layout.item3_tablayout,null);

        TabHost.TabSpec tabSpec1=mTabHost.newTabSpec("tab1");
        tabSpec1.setIndicator(v);
        tabSpec1.setContent(new Intent(this,TabActivity.class));

        TabHost.TabSpec tabSpec2=mTabHost.newTabSpec("tab2");
        tabSpec2.setIndicator(v1);
        tabSpec2.setContent(new Intent(this,TabActivity.class));

        TabHost.TabSpec tabSpec3=mTabHost.newTabSpec("tab3");
        tabSpec3.setIndicator(v2);
        tabSpec3.setContent(new Intent(this,MenuOptionsActivity.class));

        mTabHost.addTab(tabSpec1);
        mTabHost.addTab(tabSpec2);
        mTabHost.addTab(tabSpec3);

    }
}
