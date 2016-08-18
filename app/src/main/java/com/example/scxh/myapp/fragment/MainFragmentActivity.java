package com.example.scxh.myapp.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.scxh.myapp.R;

public class MainFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.fragment_test_news_list,new BlankFragment());
        transaction.add(R.id.fragment_test_txt,new NewsBlankFragment());

        transaction.commit();

//        getSupportFragmentManager().beginTransaction().add(R.id.fragment_test_news_list,new BlankFragment())  .
//                add(R.id.fragment_test_txt,new NewsBlankFragment()).commit();

    }
}
