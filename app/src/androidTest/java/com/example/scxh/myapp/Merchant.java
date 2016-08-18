package com.example.scxh.myapp;

import android.os.AsyncTask;
import android.test.AndroidTestCase;
import android.util.Log;

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

/**
 * Created by scxh on 2016/7/26.
 */
public class Merchant extends AndroidTestCase{
    private HttpURLConnection httpURLConnection;

    public void testMerchant(){
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
                    Log.e("name>>>" + merchant.getName(),"location>>>"+merchant.getLocation());
                    Log.e("distance>>>" + merchant.getDistance(),"gpsX>>>"+merchant.getGpsX());
                }
            }
        }.execute(httpDir);
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
            is.close();
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

    /*
     *将代码反编译成Json
     */
    public void testToJson(){
        List<merchant> list=new ArrayList<>();
        merchant merchant=new merchant();
        merchant.setName("汉庭酒店");
        merchant.setLocation("天府广场");
        merchant.setLocation("666m");
        merchant.setGpsX(100.223);

        Gson gson=new Gson();
        String str=gson.toJson(merchant);
        Log.e("============","str"+str);
    }
}
