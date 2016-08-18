package com.example.scxh.myapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by scxh on 2016/7/12.
 */
public class myBroadCastReciever extends BroadcastReceiver{
    String name="com.example.scxh.myBroadcasrReciever";
    @Override
    public void onReceive(Context context, Intent intent) {
      if (intent.getAction().equals(name)){
          Toast.makeText(context,"收到自定义短信",Toast.LENGTH_SHORT).show();
      }
    }
}
