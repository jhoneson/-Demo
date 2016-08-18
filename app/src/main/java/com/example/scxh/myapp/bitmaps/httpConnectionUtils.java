package com.example.scxh.myapp.bitmaps;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by scxh on 2016/7/27.
 */
public class httpConnectionUtils {

    public enum Method{
        Get,Post;
    }
    //// TODO: 2016/7/28 第一步：定义接口
    public interface HttpConnectionInterface{
        void excute(String content);
    }
    //// TODO: 2016/7/28 声明接口
    public HttpConnectionInterface mHttpConnectionInterface;
    //todo 实例化接口
    public void setOnHttpConnectionInterface(HttpConnectionInterface httpConnectionInterface){
        this.mHttpConnectionInterface=httpConnectionInterface;
    }

    public void asyncConnection(final String httpUrl, final HashMap<String,String> paramsMap, final Method method, final HttpConnectionInterface mHttpConnectionInterface){
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... params) {
                String httpUrls=params[0];
                return doHttpConnection(httpUrls,paramsMap,method);
            }
        }.execute(httpUrl);
    }

    //// TODO: 2016/7/28 判断是GET请求还是POST请求，并作出响应
    public String doHttpConnection(final String httpUrl, HashMap<String, String> paramtMap, Method method){
        if(method==Method.Get){
            String paramUrl=Loop(httpUrl,paramtMap);
            return doGetHttp(httpUrl+paramUrl);
        }else if(method==Method.Post){
            return doPostHttp(httpUrl,paramtMap);
        }
        return null;
    }

    //发送post请求
    public String doPostHttp(String httpUrl, HashMap<String, String> paramtMap) {
        String paramUrl = "";
        paramUrl = Loop(paramUrl, paramtMap); //userName=admin&passWord=1234566
        String message = "";
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(httpUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");  //请求方法 GET POST
            urlConnection.setConnectTimeout(10000); //连接超时时间
            urlConnection.setReadTimeout(15000);
            urlConnection.setDoOutput(true);
            //读数据超时
            urlConnection.connect();

            // post请求的参数
            String data = paramUrl;
            // 获得一个输出流,向服务器写数据,默认情况下,系统不允许向服务器输出内容
            OutputStream out = urlConnection.getOutputStream();// 获得一个输出流,向服务器写数据
            out.write(data.getBytes());
            out.flush();
            out.close();

            int code = urlConnection.getResponseCode();  //状态行:状态码 200 OK
            Log.e("","code :" + code);
            if (code == HttpURLConnection.HTTP_OK) {
                InputStream is = urlConnection.getInputStream();
                message = readInput(is);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return message;
    }

    //遍历 HashMap
    public String Loop(String paramUrl,HashMap<String, String> paramtMap){
        for(String key:paramtMap.keySet()){
            String value=paramtMap.get(key);
            paramUrl=paramUrl+key+"="+value+"&";
        }
        paramUrl = paramUrl.substring(0, paramUrl.length() - 1);
        return paramUrl;
    }
    /**
     * 从网络获取文本
     *
     * @param
     * @return
     */
    public String doGetHttp(String httpUrl) {
        String message = "";
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(httpUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");  //请求方法 GET POST
            urlConnection.setConnectTimeout(10000); //连接超时时间
            urlConnection.setReadTimeout(15000);    //读数据超时
            urlConnection.connect();

            int code = urlConnection.getResponseCode();  //状态行:状态码 200 OK
            Log.e("","code :" + code);
            if (code == HttpURLConnection.HTTP_OK) {
                InputStream is = urlConnection.getInputStream();
                message = readInput(is);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return message;
    }

    public String readInput(InputStream is) {
        Reader reader = new InputStreamReader(is);  //字节转字符流
        BufferedReader br = new BufferedReader(reader); //字符缓存流

        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                reader.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
