package com.example.scxh.myapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by scxh on 2016/7/11.
 */
public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        System.out.println("onCreate");
        super.onCreate();

    }
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action=intent.getExtras().getString("param");
        if(action.equals("oper1")){
            Log.e("oper1","开始下载");
        }else if(action.equals("oper2")){
            Log.e("oper2","开始下载");
            System.out.println("Operation2");
        }
        SystemClock.sleep(2000);
        Log.e("1111111","下载完成");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();
    }
}
