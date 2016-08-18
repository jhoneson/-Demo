package com.example.scxh.myapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by scxh on 2016/7/18.
 */
public class DownloadTask extends AsyncTask<String,Integer,Boolean> {
    private ProgressDialog mprogressDialog;
    private Context context;
    public DownloadTask(Context context){
        mprogressDialog=new ProgressDialog(context);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mprogressDialog.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String url=params[0];  //下载文件地址
        Log.e("doInBackground >>>>>","httpUrl:"+url);
        int count=1;
        for(;count<100;count++){
            SystemClock.sleep(50);
            publishProgress(count);
        }

        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mprogressDialog.setMessage("文件已下载"+ values[0]+"%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        mprogressDialog.dismiss();
        if(aBoolean){
            Toast.makeText(context,"文件下载成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"文件下载失败",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
