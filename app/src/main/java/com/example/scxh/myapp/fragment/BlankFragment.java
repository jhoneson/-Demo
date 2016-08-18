package com.example.scxh.myapp.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.scxh.myapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BlankFragment extends Fragment {
    private TextView textView;
    String httpUrl="http://192.168.5.3/webroot/around";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_my_blank, container, false);
        textView= (TextView) v.findViewById(R.id.fragment_test_txt);
        getDataFromHTTP();
        return v;
    }
    public void getDataFromHTTP(){
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... params) {
                 String text=params[0];
                String content = null;
                try {
                    content= loadDataFromNet(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return content;
            }

            @Override
            protected void onPostExecute(String s) {
                textView.setText(s);
            }
        }.execute(httpUrl);
    }
    public String loadDataFromNet(String httpUrl) throws IOException {
        StringBuilder builder = null;
            URL url=new URL(httpUrl);
        HttpURLConnection httpURLConnection= null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream is=httpURLConnection.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            builder=new StringBuilder();
            String line=null;
            while ((line = br.readLine()) != null){
                builder.append(line);
                Log.e("","line:  "+line);
            }
            br.close();
            isr.close();
            is.close();
            httpURLConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

}
