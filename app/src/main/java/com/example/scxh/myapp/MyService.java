package com.example.scxh.myapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;

public class MyService extends Service {
    private int mCount=0;
    private boolean flag=true;
    public MyService() {}
    //第一步：定义通讯接口,抽象方法
    interface Count{
        int getCount();
        void stop();
    }
    //第二步：定义ICountService类继承Binder实现ICount通讯接口
    public class ICountService extends Binder implements Count{

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public void stop() {
             flag=false;
        }
    }
    //第三步: 实例化ICountService类,将实例化对象作为返回值在onBind方法中返回。
    public ICountService iCountService=new ICountService();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return iCountService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag){
                    ++mCount;
                    SystemClock.sleep(1000);
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iCountService.stop();
    }

}
