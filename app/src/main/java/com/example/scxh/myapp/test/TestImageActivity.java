package com.example.scxh.myapp.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.scxh.myapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class TestImageActivity extends AppCompatActivity {
    private ViewPager mListView;
    private HashMap<String, Bitmap> item = new HashMap<>();
    private MyImageListAdapter myNetAdapter;
    private ArrayList<String> imageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_image_layout);
        imageUrls.add("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg");
        imageUrls.add("http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg");
        imageUrls.add("http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg");
        imageUrls.add("http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg");
        imageUrls.add("http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg");
        imageUrls.add("http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg");
        imageUrls.add("http://img.my.csdn.net/uploads/201407/26/1406383265_8550.jpg");
        imageUrls.add("http://img.my.csdn.net/uploads/201407/26/1406383264_3954.jpg");
        imageUrls.add("http://img.my.csdn.net/uploads/201407/26/1406383264_4787.jpg");
        mListView = (ViewPager) findViewById(R.id.test_image);
        myNetAdapter = new MyImageListAdapter(this);
        mListView.setAdapter(myNetAdapter);
        myNetAdapter.setData(imageUrls);

    }


    private class MyImageListAdapter extends PagerAdapter {
        ArrayList<String> mUrls = new ArrayList<>();
        Context mContext;

        public MyImageListAdapter(Context Context) {
            mContext = Context;
        }

        public void setData(ArrayList<String> urls) {
            mUrls = urls;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mUrls.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.item_test_list_layout, null);
            ImageView ImageView = (android.widget.ImageView) v.findViewById(R.id.item_test_images);
            Glide.with(mContext).load(mUrls.get(position)).into(ImageView);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = container.getChildAt(position);
            container.removeView(v);
        }
    }
}
//    public class MyImageListAdapter extends BaseAdapter {
//        private String[] list = new String[]{};
//        LayoutInflater layoutInflater;
//
//        public MyImageListAdapter(Context context) {
//            layoutInflater = LayoutInflater.from(context);
//        }
//
//        public void setData(String[] array) {
//            this.list = array;
//            notifyDataSetChanged();
//        }
//
//        @Override
//        public int getCount() {
//            return list.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return list[position];
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            final ImageView imageView;
//            if (convertView == null) {
//                convertView = layoutInflater.inflate(R.layout.item_test_list_layout, null);
//                ImageView image = (ImageView) convertView.findViewById(R.id.item_test_images);
//                convertView.setTag(image);
//            }
//            imageView = (ImageView) convertView.getTag();
//
//            String itemUrl = (String) getItem(position);  //设置图片路径
//            if (bitMap != null) {
//                Bitmap bitmap = item.get(httpUrl);
//                imageView.setImageBitmap(bitmap);
//            } else {
//                //线程中执行
//                new AsyncTask<String, Void, Bitmap>() {
//                    @Override
//                    protected Bitmap doInBackground(String... params) {
//                        String path = params[0];
//                        bitMap = getHttpBitmap(path);
//                        return bitMap;
//                    }
//
//                    @Override
//                    protected void onPostExecute(Bitmap bitmap) {
//
//                        imageView.setImageBitmap(bitmap);
//                    }
//                }.execute(itemUrl);
//            }
//            return convertView;
//        }
//
//        /*
//         *从网络获取图片
//         */
//        public Bitmap getHttpBitmap(String httpUrls) {
//            Bitmap bitmap = null;
//            try {
//                URL url = new URL(httpUrls);
//                InputStream in = url.openStream();
//                bitmap = BitmapFactory.decodeStream(in);
//                item.put(httpUrls, bitmap);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return bitmap;
//        }
//    }

