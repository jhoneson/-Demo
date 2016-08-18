package com.example.scxh.myapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import helper.Info;
import helper.merchant;
import helper.store;

public class JsonActivity extends AppCompatActivity {
    private ListView mListView;
    private HttpURLConnection httpURLConnection;
    private store store;
    private ArrayList<store> array = new ArrayList<store>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        mListView = (ListView) findViewById(R.id.json_list_view);
        MyAdapter adapter = new MyAdapter(this);
        ArrayList<store> list = getData();
        mListView.setAdapter(adapter);
        adapter.setData(array);
        Log.e("2222222222", "uponV>>>>>>>>>>>>");
    }

    /*
     *调方法在异步取数据
     */
    public ArrayList<store> getData() {
        final String httpDir = "http://192.168.5.3/webroot/around";
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... params) {
                String dir=params[0];
                return ReadDataFromStore(dir);
            }

            @Override
            protected void onPostExecute(String s) {
                Gson gson=new Gson();
                Info info=gson.fromJson(s,Info.class);
                List<merchant> merchants=info.getMerchantKey();
                for(merchant merchant:merchants){
                    store m=new store();
                    m.setLocation(merchant.getLocation());
                    m.setName(merchant.getName());
                    m.setDistance(merchant.getDistance());
                    m.setPicUrl(merchant.getPicUrl());
                    m.setCoupon(merchant.getCoupon());

                    array.add(m);
                }
            }
        }.execute(httpDir);
        return array;

    }

    /*
     *联网去数据
     */
    public String ReadDataFromStore(String httpDir) {
        URL url= null;
        InputStream is=null;
        String msg=null;
        try {
            url = new URL(httpDir);
            httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            int code=httpURLConnection.getResponseCode();
            Log.e("111111","code:"+code);
            httpURLConnection.connect();
            is=httpURLConnection.getInputStream();
            msg=readIOFile(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(is !=null) {
                is.close();
            }
            httpURLConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;

    }

    /*
    *从文件读数据
    */
    public String readIOFile(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        isr.close();
        return sb.toString();
    }
    public class MyAdapter extends BaseAdapter{
        ArrayList<store> list=new ArrayList<>();
        LayoutInflater layoutInflater;
        public MyAdapter(Context context){
            layoutInflater=LayoutInflater.from(context);
        }
        public void setData( ArrayList<store> list){
            this.list=list;
            notifyDataSetChanged();
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
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.json_item_layout,null);
                ImageView icon= (ImageView) convertView.findViewById(R.id.json_icon);
                TextView title= (TextView) convertView.findViewById(R.id.json_title);
                TextView content= (TextView) convertView.findViewById(R.id.json_upon);
                TextView location= (TextView) convertView.findViewById(R.id.json_adress);
                TextView distance= (TextView) convertView.findViewById(R.id.json_distance);

                viewHolder=new ViewHolder();
                viewHolder.iconV=icon;
                viewHolder.titleV=title;
                viewHolder.uponV=content;
                viewHolder.locationV=location;
                viewHolder.distanceV=distance;
                convertView.setTag(viewHolder);
            }
            viewHolder= (ViewHolder) convertView.getTag();
            store item= (helper.store) getItem(position);
            Glide.with(JsonActivity.this).load(item.getPicUrl()).into(viewHolder.iconV);  //使用工具类联网取图片
            viewHolder.titleV.setText(item.getName());
            Log.e("1111","titleV:"+item.getName());
            viewHolder.uponV.setText(item.getCoupon());
            Log.e("2222222222","uponV:"+item.getCoupon());
            viewHolder.locationV.setText(item.getLocation());
            viewHolder.distanceV.setText(item.getDistance());

            return convertView;
        }
    }
    class ViewHolder{
        ImageView iconV;
        TextView titleV,uponV,locationV,distanceV;
    }
}
