package com.example.scxh.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener {
    public ViewPager mviewpager;
    private TextView mTextView1,mTextView2,mTextView3,mTextView4;
    private ImageView Pimage1,Pimage2,Pimage3,Pimage4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_layout);
        mviewpager= (ViewPager) findViewById(R.id.pic1);


        //// TODO: 2016/6/8 实例化文本控件
        mTextView1= (TextView) findViewById(R.id.viewPager_txt1);
        mTextView2= (TextView) findViewById(R.id.viewPager_txt2);
        mTextView3= (TextView) findViewById(R.id.viewPager_txt3);
        mTextView4= (TextView) findViewById(R.id.viewPager_txt4);

        ////// TODO: 2016/6/12 监听文本文件 
        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        mTextView4.setOnClickListener(this);

        // TODO: 2016/6/12 实例化图片资源控件
        Pimage1= (ImageView) findViewById(R.id.page1);
        Pimage2= (ImageView) findViewById(R.id.page2);
        Pimage3= (ImageView) findViewById(R.id.page3);
        Pimage4= (ImageView) findViewById(R.id.page4);


        ////todo 利用解析器解析布局文件获得view控件
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View v1=layoutInflater.inflate(R.layout.viewpager_layout,null);
        View v2=layoutInflater.inflate(R.layout.viewpagerlayout,null);
        View v3=layoutInflater.inflate(R.layout.viewpagerlayout1,null);
        View v4=layoutInflater.inflate(R.layout.viewpagerlayout2,null);

        List<View> list = new ArrayList<>();
        list.add(v2);
        list.add(v4);
        list.add(v3);
        list.add(v1);

        // TODO: 2016/6/8 实例化适配器 
        myViewPagerAdapter adapter = new myViewPagerAdapter(list);
        mviewpager.setAdapter(adapter);
        mTextView1.setTextColor(Color.RED);
        mviewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }
            //// TODO: 2016/6/8 设置被选中为红色
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mTextView1.setTextColor(Color.RED);
                        mTextView2.setTextColor(Color.GREEN);
                        mTextView3.setTextColor(Color.GREEN);
                        mTextView4.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        mTextView1.setTextColor(Color.GREEN);
                        mTextView2.setTextColor(Color.RED);
                        mTextView3.setTextColor(Color.GREEN);
                        mTextView4.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        mTextView1.setTextColor(Color.GREEN);
                        mTextView2.setTextColor(Color.GREEN);
                        mTextView3.setTextColor(Color.RED);
                        mTextView4.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        mTextView1.setTextColor(Color.GREEN);
                        mTextView2.setTextColor(Color.GREEN);
                        mTextView3.setTextColor(Color.GREEN);
                        mTextView4.setTextColor(Color.RED);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.viewPager_txt1:
                mTextView1.setTextColor(Color.RED);
                mTextView2.setTextColor(Color.GREEN);
                mTextView3.setTextColor(Color.GREEN);
                mTextView4.setTextColor(Color.GREEN);
                mviewpager.setCurrentItem(0);
                break;
            case  R.id.viewPager_txt2:
                mTextView1.setTextColor(Color.GREEN);
                mTextView2.setTextColor(Color.RED);
                mTextView3.setTextColor(Color.GREEN);
                mTextView4.setTextColor(Color.GREEN);
                mviewpager.setCurrentItem(1);
                break;
            case R.id.viewPager_txt3:
                mTextView1.setTextColor(Color.GREEN);
                mTextView2.setTextColor(Color.GREEN);
                mTextView3.setTextColor(Color.RED);
                mTextView4.setTextColor(Color.GREEN);
                mviewpager.setCurrentItem(2);
                break;
            case R.id.viewPager_txt4:
                mTextView1.setTextColor(Color.GREEN);
                mTextView2.setTextColor(Color.GREEN);
                mTextView3.setTextColor(Color.GREEN);
                mTextView4.setTextColor(Color.RED);
                mviewpager.setCurrentItem(3);
                break;
        }
    }


    public class myViewPagerAdapter extends PagerAdapter{
        private List<View> list = new ArrayList<>();
        public myViewPagerAdapter(List<View> list){
            this.list=list;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = list.get(position);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = list.get(position);
            container.removeView(v);
        }
    }
}
