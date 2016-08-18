package com.example.scxh.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ToolBarActivity extends AppCompatActivity {
    public Toolbar mtoolBar;
    public ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_layout);

        mtoolBar= (Toolbar) findViewById(R.id.toolbar_1);
        mtoolBar.inflateMenu(R.menu.caidan);

        mListView= (ListView) findViewById(R.id.listview_toolbar);
        String[] array ={"添加","编辑","删除"};
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.activity_menu_options_layout,array);
        mListView.setAdapter(adapter);
        registerForContextMenu(mListView);
        mtoolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ff:
                        Toast.makeText(ToolBarActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ToolBarActivity.this,MenuOptionsActivity.class));break;
                    case R.id.yy:
                        Toast.makeText(ToolBarActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ToolBarActivity.this,MenuOptionsActivity.class));break;
                    case R.id.hh:
                        Toast.makeText(ToolBarActivity.this,"编辑成功",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        mtoolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolBarActivity.this,"返回",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.caidan,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}

