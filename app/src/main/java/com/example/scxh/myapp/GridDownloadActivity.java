package com.example.scxh.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class GridDownloadActivity extends AppCompatActivity {
    private HashMap<String,Bitmap> item=new HashMap<>();
    private GridView gridView;
    private myAdapter myNetAdapter;
    String httpUrl;
    Bitmap bitMap;
    String[] path={"http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg ",
            "http://img.my.csdn.net/uploads/201407/26/1406383265_8550.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383264_3954.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383264_4787.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg \n",
            "http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_doenload);
        gridView= (GridView) findViewById(R.id.http_grid);
        myNetAdapter=new myAdapter(this);
        gridView.setAdapter(myNetAdapter);
        myNetAdapter.setData(path);

    }


    public class myAdapter extends BaseAdapter {
        String[] array = new String[]{};
        LayoutInflater layoutInflater;

        public myAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);
        }

        public void setData(String[] array) {
            this.array = array;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return array.length;
        }

        @Override
        public Object getItem(int position) {
            return array[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ImageView imageView;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.item_layout, null);
                ImageView image = (ImageView) convertView.findViewById(R.id.item_images);
                convertView.setTag(image);
            }
            imageView = (ImageView) convertView.getTag();

            String itemUrl = (String) getItem(position);  //设置图片路径
            if (bitMap != null) {
                Bitmap bitmap=item.get(httpUrl);
                imageView.setImageBitmap(bitmap);
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

                        imageView.setImageBitmap(bitmap);
                    }
                }.execute(itemUrl);
            }
            return convertView;
        }
        /*
         *从网络获取图片
         */
        public Bitmap getHttpBitmap(String httpUrls) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(httpUrls);
                InputStream in=url.openStream();
                bitmap=BitmapFactory.decodeStream(in);

//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                InputStream is = connection.getInputStream();
//                bitmap = BitmapFactory.decodeStream(is);
                item.put(httpUrls,bitmap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
    }
}
