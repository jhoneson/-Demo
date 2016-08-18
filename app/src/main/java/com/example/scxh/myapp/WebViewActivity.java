package com.example.scxh.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView= (WebView) findViewById(R.id.web_view);

        mWebView.getSettings().setJavaScriptEnabled(true);//第一步：设置JavaScript可用
        //第三步 添加javaScript交互接口到webview
        mWebView.addJavascriptInterface(new myWebViewInterface() {
            @Override
            public void showToast() {
                Toast.makeText(WebViewActivity.this,"原生与网页交互完成",Toast.LENGTH_SHORT).show();
            }
        },"myWebViewInterface");
    }
    //第二步：创建JAVASCRIPT交互接口
    interface myWebViewInterface{
        void showToast ();
    }
}
