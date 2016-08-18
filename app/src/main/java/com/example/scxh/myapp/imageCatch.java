package com.example.scxh.myapp;

import android.graphics.Bitmap;

import java.util.HashMap;

/**
 * Created by scxh on 2016/7/19.
 */
public class imageCatch {
    public HashMap<String,Bitmap> item=new HashMap<>();
    /*
     *存入图片
     */
    public void put(String url,Bitmap bitmap){
        item.put(url,bitmap);
    }
    /*
     *取出图片
     */
    public void get(String url){
        item.get(url);
    }
}
