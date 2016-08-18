package com.example.scxh.myapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewActivity extends AppCompatActivity {
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mListView= (ListView) findViewById(R.id.listView_list);
        ArrayList list=getListMessageData();
        MyBaseAdapter myBaseAdapter =new MyBaseAdapter(list,this);
        mListView.setAdapter(myBaseAdapter);

    }

    public class MyBaseAdapter extends BaseAdapter{
        private ArrayList<HashMap<String,Object>> list=new ArrayList<>();
        private LayoutInflater layoutinflater;
        public MyBaseAdapter(ArrayList<HashMap<String,Object>> list, Context context){
            this.list=list;
            layoutinflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            //TODO一级优化  优化View不被重复解析
            if(convertView==null){
                convertView= layoutinflater.inflate(R.layout.layout,null);
                ImageView iconImg= (ImageView) convertView.findViewById(R.id.pop_image);
                TextView titleTxt= (TextView) convertView.findViewById(R.id.pop_title);
                TextView contentTxt= (TextView) convertView.findViewById(R.id.pop_content);

                //二级优化  优化view控件不被重复加载
                viewHolder = new ViewHolder();
                viewHolder.iconImg = iconImg;
                viewHolder.titleTxt = titleTxt;
                viewHolder.contentTxt = contentTxt;
                convertView.setTag(viewHolder);
            }
            //从View对象中获取控件实例
            viewHolder = (ViewHolder) convertView.getTag();
            HashMap<String,Object> item= (HashMap<String, Object>) getItem(position);
            viewHolder.iconImg.setImageResource((int)item.get("icon"));
            viewHolder.titleTxt.setText((String) item.get("title"));
            viewHolder.contentTxt.setText((String) item.get("content"));
            return convertView;
        }
        class ViewHolder{
            ImageView iconImg;
            TextView titleTxt;
            TextView contentTxt;
        }
    }
    public ArrayList<HashMap> getListMessageData() {
        ArrayList<HashMap> listData = new ArrayList<HashMap>();

        HashMap<String, Object> item = new HashMap<String, Object>();
        item.put("icon", R.drawable.m3);
        item.put("title", "【勾魂面】");
        item.put("content", "全场5折，全程通用，提供免费WiFi！");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.drawable.i2);
        item.put("title", "【红旗超市】");
        item.put("content", "全场5折，全程通用全场5折，全程通用，还提供免费WiFi！");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.drawable.i3);
        item.put("title", "【三亚】");
        item.put("content", "全场5折，全程通用，还提供免费WiFi！");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.drawable.i4);
        item.put("title", "【沙县小吃】");
        item.put("content", "全场5折，全程通用，还提供免费WiFi！");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.drawable.mao);
        item.put("title", "【麦当劳】");
        item.put("content", "全场5折，全程通用，还提供免费WiFi！");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.drawable.mao);
        item.put("title", "【肯德基】");
        item.put("content", "全场5折，全程通用，还提供免费WiFi！");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.drawable.m3);
        item.put("title", "【肯德基】");
        item.put("content", "全场5折，全程通用，还提供免费WiFi！");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.drawable.m03);
        item.put("title", "【肯德基】");
        item.put("content", "全场5折，全程通用，还提供免费WiFi！");
        listData.add(item);

        return listData;
    }
}
