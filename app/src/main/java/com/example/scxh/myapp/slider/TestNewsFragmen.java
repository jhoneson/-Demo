package com.example.scxh.myapp.slider;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.scxh.myapp.R;
import com.scxh.slider.library.SliderLayout;
import com.scxh.slider.library.SliderTypes.BaseSliderView;
import com.scxh.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.TestsliderHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestNewsFragmen extends Fragment {
    private ListView mListView;
    public static Fragment newInstance() {
        TestNewsFragmen fragment = new TestNewsFragmen();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_image_slider_demo, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView= (ListView)getView(). findViewById(R.id.test_slider_list);
        SliderAdapter adapter=new SliderAdapter(getContext());
        mListView.addHeaderView(inflateSliderLayout());
        mListView.setAdapter(adapter);
        adapter.setData(Data());
    }
    // 添加自定义布局到HeadView上
    public View inflateSliderLayout(){
        View v=LayoutInflater.from(getContext()).inflate(R.layout.item_test_slider_layout,null);
        SliderLayout mSliderLayout= (SliderLayout) v.findViewById(R.id.test_slider_layout);
        HashMap<String,String> http_url_maps = getData();
        Log.e("","http_url_maps>>>>"+http_url_maps.size());
        for(String name : http_url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            textSliderView.description(name)
                    .image(http_url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            mSliderLayout.addSlider(textSliderView);
        }
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        return v;
    }

    public List<TestsliderHelper> Data(){
        ArrayList<TestsliderHelper> list=new ArrayList<>();
        TestsliderHelper item=new TestsliderHelper();
        item.setIcon(R.drawable.m11);
        item.setTitle("习近平接受八国新任驻华大使递交国书");
        item.setContent("经济法hihi尽快恢复计划放过机会今年 你发附件方法好久不付款剪短发哪家今年解放军");
        list.add(item);

        item=new TestsliderHelper();
        item.setIcon(R.drawable.m12);
        item.setTitle("天津港总裁出席发布会");
        item.setContent("经济法hihi尽快恢复计划放过机会今年 你发附件方法好久不付款剪短发哪家今年解放军");
        list.add(item);

        item=new TestsliderHelper();
        item.setIcon(R.drawable.m13);
        item.setTitle("瑞海公司从消防鉴定到安评一路畅通无阻");
        item.setContent("经济法hihi尽快恢复计划放过机会今年 你发附件方法好久不付款剪短发哪家今年解放军");
        list.add(item);

        item=new TestsliderHelper();
        item.setIcon(R.drawable.m14);
        item.setTitle("Airbnb高调入华 命运将如Uber一样吗？");
        item.setContent("经济法hihi尽快恢复计划放过机会今年 你发附件方法好久不付款剪短发哪家今年解放军");
        list.add(item);

        return list;
    }
    private HashMap<String,String> getData(){
        HashMap<String,String> http_url_maps = new HashMap<String, String>();
        http_url_maps.put("习近平接受八国新任驻华大使递交国书", "http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg");
        http_url_maps.put("天津港总裁出席发布会", "http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg");
        http_url_maps.put("瑞海公司从消防鉴定到安评一路畅通无阻", "http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg");
        http_url_maps.put("Airbnb高调入华 命运将如Uber一样吗？", "http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg");

        return http_url_maps;
    }

    class SliderAdapter extends BaseAdapter {
        private static final int ITEM_TYPE_ONE = 0; //三张图片
        private static final int ITEM_TYPE_TWO = 1;
        private List<TestsliderHelper> list=new ArrayList<>();
        LayoutInflater layoutInflater;
        Context context;
        public SliderAdapter(Context context){
            layoutInflater=LayoutInflater.from(context);
            this.context=context;
        }
        public List setData(List<TestsliderHelper> lists){
            this.list=lists;
            notifyDataSetChanged();
            return list;
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
            int type = getItemViewType(position);
            //todo 判断：ITEM_TYPE_ONE 显示三张图片,其余显示其他的
            if(type==ITEM_TYPE_ONE){
                return getTwoView(position,convertView,parent);
            }else {
                return getOneView(position,convertView,parent);
            }
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            TestsliderHelper item= (TestsliderHelper) getItem(position);
            //todo 加判断
            if(item.getTitle().contains("瑞海公司")){
                return ITEM_TYPE_ONE;
            }else {
                return ITEM_TYPE_TWO;
            }
        }

        //todo 两种返回的VIEW需要用同一个适配器和数据源


        public View getOneView(int position, View convertView, ViewGroup parent) {
            SHelper sHelper;
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.item_testlayout,null);
                ImageView icon= (ImageView) convertView.findViewById(R.id.test_left_images);
                TextView Title= (TextView) convertView.findViewById(R.id.test_left_up_title_txt);
                TextView Content= (TextView) convertView.findViewById(R.id.test_center_content);
                sHelper=new SHelper();
                sHelper.leftImage=icon;
                sHelper.titleTxt=Title;
                sHelper.contentTxt=Content;
                convertView.setTag(sHelper);
            }
            sHelper= (SHelper) convertView.getTag();
            TestsliderHelper item= (TestsliderHelper) getItem(position);
            sHelper.leftImage.setImageResource(item.getIcon());
            sHelper.titleTxt.setText(item.getTitle());
            sHelper.contentTxt.setText(item.getContent());
            return convertView;
        }
        public View getTwoView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView==null) {
                convertView = layoutInflater.inflate(R.layout.item_test_two_layou, null);
                ImageView one= (ImageView) convertView.findViewById(R.id.image_one);
                ImageView two= (ImageView) convertView.findViewById(R.id.image_three);
                ImageView three= (ImageView) convertView.findViewById(R.id.image_two);
                viewHolder=new ViewHolder();
                viewHolder.imageOne=one;
                viewHolder.imageThree=three;
                viewHolder.imageTwo=two;

                convertView.setTag(viewHolder);
            }
            viewHolder= (ViewHolder) convertView.getTag();
            TestsliderHelper item= (TestsliderHelper) getItem(position);
            viewHolder.imageOne.setImageResource(item.getIcon());
            return convertView;
        }
    }
    class SHelper{
        ImageView leftImage;
        TextView titleTxt;
        TextView contentTxt;
    }
    class ViewHolder{
        ImageView imageOne;
        ImageView imageTwo;
        ImageView imageThree;
    }
}
