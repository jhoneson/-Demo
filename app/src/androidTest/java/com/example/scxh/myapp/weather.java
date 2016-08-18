package com.example.scxh.myapp;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class weather extends AndroidTestCase {
    private Context context;
    @Override
    protected void setUp() throws Exception {
       context=getContext();
    }
    public void testGet() throws IOException, JSONException {
        InputStream is=context.getAssets().open("weather");
        String text=getFile(is);
        Log.e("0000000000000","text:"+text);
        JSONObject object=new JSONObject(text);
        JSONObject json=object.getJSONObject("weatherinfo");
        String city=json.getString("city");
        Log.e("1111111","city:"+city);
        int temp=json.getInt("temp");
        Log.e("2222222222","temp:"+temp);
    }
    public String getFile(InputStream is) throws IOException {
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        String line=null;
        StringBuilder builder=new StringBuilder();
        while ((line=br.readLine())!=null){
            builder.append(line);
        }
        br.close();
        isr.close();
        return builder.toString();
    }
}
