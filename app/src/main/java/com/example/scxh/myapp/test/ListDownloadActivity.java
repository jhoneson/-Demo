package com.example.scxh.myapp.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class ListDownloadActivity extends AppCompatActivity {
    private HashMap<String, Bitmap> item = new HashMap<>();
    private ViewPager gridView;
    private myAdapter myNetAdapter;
    String httpUrl;
    Bitmap bitMap;
    ImageView mImageView;
    String[] path = {"http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg ",
            "http://img.my.csdn.net/uploads/201407/26/1406383265_8550.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383264_3954.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383264_4787.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_doenload);
        gridView = (ViewPager) findViewById(R.id.http_list);
        myNetAdapter = new myAdapter(this);
        gridView.setAdapter(myNetAdapter);
        myNetAdapter.setData(path);

    }

    public class myAdapter extends PagerAdapter {
        private String[] pic=new String[]{};
        LayoutInflater layoutInflater;
        public String[] setData(String[] list) {
            this.pic = list;
            notifyDataSetChanged();
            return pic;
        }
        public myAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return pic.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = change(pic[position]);
            container.addView(v);
            return v;

        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = change(pic[position]);
            container.removeView(v);
        }
    }

    public ImageView change(String url) {
        View v = LayoutInflater.from(this).inflate(R.layout.item_image_layout, null);
        mImageView = (ImageView) v.findViewById(R.id.test_item_pager);
        if (bitMap != null) {
            Bitmap bitmap = item.get(url);
            mImageView.setImageBitmap(bitmap);
        } else {
            //线程中执行
            new AsyncTask<String, Void, Bitmap>() {
                @Override
                protected Bitmap doInBackground(String... params) {
                    String path = params[0];
                    bitMap = getHttpBitmap(path);
                    return bitMap;
                }
                @Override
                protected void onPostExecute(Bitmap bitmap) {

                    mImageView.setImageBitmap(bitmap);
                }
            }.execute(httpUrl);
        }
        return mImageView;
    }

    /*
       *从网络获取图片
       */
    public Bitmap getHttpBitmap(String httpUrls) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(httpUrls);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream in= httpURLConnection.getInputStream();
            bitmap= BitmapFactory.decodeStream(in);
            item.put(httpUrls,bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
