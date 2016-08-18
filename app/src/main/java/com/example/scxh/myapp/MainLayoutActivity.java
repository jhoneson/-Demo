package com.example.scxh.myapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.scxh.myapp.animation.AnimationActivity;
import com.example.scxh.myapp.animation.XmlAnimaterActivity;
import com.example.scxh.myapp.bitmaps.GetPicActivity;
import com.example.scxh.myapp.finfish.AActivity;
import com.example.scxh.myapp.finfish.List.OneActivity;
import com.example.scxh.myapp.finfish.RSstyle.aActivity;
import com.example.scxh.myapp.finfish.result.FirstActivity;
import com.example.scxh.myapp.fragment.FragmentLifeActivity;
import com.example.scxh.myapp.fragment.MainFragmentActivity;
import com.example.scxh.myapp.slider.NewsAddActivity;
import com.example.scxh.myapp.test.ListDownloadActivity;
import com.example.scxh.myapp.test.TestImageActivity;

import java.util.ArrayList;
import java.util.List;


public class MainLayoutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
        public ListView mListView;
        public List<MainIntentBean> list = new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_layout);
            mListView = (ListView) findViewById(R.id.listView_main);

            inintData();

            MainIntentAdapter adapter = new MainIntentAdapter(this);
            adapter.setList(list);

            mListView.setAdapter(adapter);
            mListView.setOnItemClickListener(this);
        }

        /**
         * 初始化数据源
         */
        public void inintData(){
            addItem("toolBar学习",ToolBarActivity.class);
            addItem("menu菜单学习",MenuOptionsActivity.class);
            addItem("popup学习",PopupActivity.class);
            addItem("对话框练习",DialogActivity.class);
            addItem("ListView练习",ListViewActivity.class);
            addItem("登录对话框",LoginActivity.class);
            addItem("划屏操作",ViewPagerActivity.class);
            addItem("ProgressBar练习",ProgressBarActivity.class);
            addItem("延迟显示",TransportActivity.class);
            addItem("页卡操作",TabActivity.class);
            addItem("美团练习",MeituanActivity.class);
            addItem("service获取计数",GetCountActivity.class);
            addItem("serviceIntent异步处理",MyintentServiceActivity.class);
            addItem("broadCastReviever",MyBroadcastActivity.class);
            addItem("网络取图片",GridDownloadActivity.class);
            addItem("网络本地取大图片",bigPictureActivity.class);
            addItem("异步加载图片",AsyntaskActivity.class);
            addItem("异步加载文本",ServletActivity.class);
            addItem("原生与网页交互",WebViewActivity.class);
            addItem("解析Json文件",JsonActivity.class);
            addItem("用工具包加载文字", GetPicActivity.class);
            addItem("fragment初学_静态加载", MainFragmentActivity.class);
            addItem("fragment生命周期", FragmentLifeActivity.class);
            addItem("androidTest", TestImageActivity.class);
            addItem("androidTestList", ListDownloadActivity.class);
            addItem("主页左右滑动实现", NewsAddActivity.class);
            addItem("补间动画和组合动画", AnimationActivity.class);
            addItem("xml属性动画", XmlAnimaterActivity.class);
            addItem("一次完全取消Activity之Broadcast",AActivity.class);
            addItem("一次完全取消Activity之arrayList",OneActivity.class);
            addItem("一次完全取消Activity之RS", aActivity.class);
            addItem("一次完全取消Activity之回传参", FirstActivity.class);

        }

        public <T> void addItem(String title,Class<T> t){
            MainIntentBean mainIntentBean = new MainIntentBean(title,t);
            list.add(mainIntentBean);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MainIntentAdapter adapter = (MainIntentAdapter) parent.getAdapter();
            MainIntentBean mainIntentBean = (MainIntentBean) adapter.getItem(position);
            Intent intent = new Intent(this,mainIntentBean.toActivityClass);
            startActivity(intent);
        }

        public class MainIntentAdapter extends BaseAdapter {
            private List<MainIntentBean> list = new ArrayList<>();
            private LayoutInflater layoutInflater;
            public MainIntentAdapter(Context context){
                layoutInflater = LayoutInflater.from(context);
            }
            public void setList(List<MainIntentBean> list){
                this.list = list;
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
                if(convertView == null){
                    convertView = layoutInflater.inflate(android.R.layout.simple_list_item_1,null);
                    TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
                    convertView.setTag(textView);
                }
                TextView textView = (TextView) convertView.getTag();

                MainIntentBean item = (MainIntentBean) getItem(position);
                textView.setText(item.title);
                return convertView;
            }
        }


        public class MainIntentBean<T>{
            private String title;
            private Class<T> toActivityClass;

            public MainIntentBean(String title, Class<T> toActivityClass) {
                this.title = title;
                this.toActivityClass = toActivityClass;
            }
        }
    }

