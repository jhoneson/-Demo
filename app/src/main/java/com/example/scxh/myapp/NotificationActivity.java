package com.example.scxh.myapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener{
    private Button sendBtn,updateBtn,cancelBtn,madeBtn;
    private NotificationManager mNotifyManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        sendBtn= (Button) findViewById(R.id.notification_send);
        updateBtn= (Button) findViewById(R.id.notification_update);
        cancelBtn= (Button) findViewById(R.id.notification_cancel);
        madeBtn= (Button) findViewById(R.id.notification_selfMade);
        sendBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        madeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.notification_send:
               SendNotification();
               break;
           case R.id.notification_update:
               UpdateNotification();
               break;
           case R.id.notification_selfMade:
//               selfMadeNotify();
               break;
       }
    }
    public void SendNotification(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setContentTitle("收到新消息");
        builder.setContentText("收到1条消息");
        builder.setSmallIcon(R.drawable.m03);
        builder.setTicker("来短信了");

         mNotifyManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = builder.build();
        int id=1;
        builder.setNumber(1);
        mNotifyManager.notify(id,notification);
    }
    public void UpdateNotification(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setContentTitle("收到新消息");
        builder.setContentText("收到2条消息");
        builder.setNumber(2);
        builder.setSmallIcon(R.drawable.i2);
        builder.setTicker("又来短信了");

        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = builder.build();
        int id=1; //与第一条短信ID相同
        mNotifyManager.notify(id,notification);

    }

//    public void selfMadeNotify(){
//        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
//        builder.setSmallIcon(R.drawable.lyric_poster_control_guide);
//        builder.setTicker("收到一条新消息");
//        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,100,new Intent("ViewNotify"),PendingIntent.FLAG_UPDATE_CURRENT);
//        RemoteViews remoteViews= new RemoteViews(getPackageName(),R.layout.music_notificationlayout);
//        remoteViews.setOnClickPendingIntent(R.id.playbtn,pendingIntent);
////        mNotifyManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
////        Notification notification = builder.build();
////        mNotifyManager.notify(111,notification);
//    }
}
