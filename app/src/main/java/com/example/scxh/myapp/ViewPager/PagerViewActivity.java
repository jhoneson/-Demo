package com.example.scxh.myapp.ViewPager;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.scxh.myapp.R;

import java.util.ArrayList;
import java.util.List;

public class PagerViewActivity extends AppCompatActivity {
    private ViewPager mViewPagers;
    private List<View> lists=new ArrayList<>();
    ImageView imageView;
    Bitmap bitmap;
    private String[] imageUrls = new String[]{
            "http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383265_8550.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383264_3954.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383264_4787.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_view);
        mViewPagers= (ViewPager) findViewById(R.id.test_demo);
        LayoutInflater layoutInflater=LayoutInflater.from(this);
        View v=layoutInflater.inflate(R.layout.item_image_layout,null);
        imageView= (ImageView) v.findViewById(R.id.test_item_pager);

    }

    public class PagerViewAdapter extends PagerAdapter{
//        private String[] pic=new String[]{};
        private List<View> list=new ArrayList<>();
        public PagerViewAdapter(List<View> list){
            this.list=list;
            notifyDataSetChanged();
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
            View views=list.get(position);
            container.addView(views);
            return views;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View views=list.get(position);
            container.removeView(views);
        }

    }
    public void getPic(String url){
        new AsyncTask<String,Void,Bitmap>(){

            @Override
            protected Bitmap doInBackground(String... params) {

                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
            }
        }.execute(url);
    }

}
