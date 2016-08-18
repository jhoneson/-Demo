package com.example.scxh.myapp;

import android.content.Context;
import android.os.AsyncTask;
import android.test.AndroidTestCase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

import helper.store;

/**
 * Created by scxh on 2016/7/25.
 */
public class Store extends AndroidTestCase {
    private Context context;
    private HttpURLConnection httpURLConnection;

    @Override
    protected void setUp() throws Exception {
        context = getContext();
    }

    public void testParseStore() throws IOException, JSONException {
        final String httpDir = "http://192.168.5.3/webroot/around";
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                String txtDir = params[0];
                return ReadDataFromStore(txtDir);
            }
            @Override
            protected void onPostExecute(String s) {
                try {
                    List<store> list = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray("merchantKey");
                    int length = jsonArray.length();
                    Log.e("0000000","length>>>>"+length);
                    for (int i = 0; i < length; i++) {
                        JSONObject itemObject = jsonArray.getJSONObject(i);
                        int merchantID = itemObject.getInt("merchantID");
                        String name = itemObject.getString("name");
                        String coupon = itemObject.getString("coupon");
                        String location = itemObject.getString("location");
                        String distance = itemObject.getString("distance");
                        String picUrl = itemObject.getString("picUrl");
                        String couponType = itemObject.getString("couponType");
                        String cardType = itemObject.getString("cardType");
                        String groupType = itemObject.getString("groupType");
                        Double gpsX = itemObject.getDouble("gpsX");
                        Double gpsY = itemObject.getDouble("gpsY");
                        int goodSayNum = itemObject.getInt("goodSayNum");
                        int midSayNum = itemObject.getInt("midSayNum");
                        int badSayNum = itemObject.getInt("badSayNum");

                        store store = new store();
                        store.setName(name);
                        store.setCoupon(coupon);
                        store.setLocation(location);
                        store.setDistance(distance);
                        store.setPicUrl(picUrl);
                        store.setCouponType(couponType);
                        store.setCardType(cardType);
                        store.setGroupType(groupType);
                        store.setGpsX(gpsX);
                        store.setGpsY(gpsY);
                        store.setMerchantID(merchantID);
                        store.setGoodSayNum(goodSayNum);
                        store.setMidSayNum(midSayNum);
                        store.setBadSayNum(badSayNum);
                        list.add(store);
                        Log.e("name:" + store.getName()+"   location: "+store.getLocation(), "  badSayNum:" + store.getBadSayNum());
                    }
                    Log.e("0000000000", "  list:" + list.size());
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        }.execute(httpDir);

    }

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
}
