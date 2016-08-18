package com.example.scxh.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class XmlParseActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button = (Button) findViewById(R.id.xml_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream is = null;
                try {
                    is = getAssets().open("books.xml");
                    BookParse parser = new PullBookParser();
                    ArrayList<book> book = null;
                    book = (ArrayList<book>) parser.parse(is);
                    for (book b : book) {
                        Log.i("tag", book.toString());
                        Log.e("1111111111", "id:" + b.getId());
                        Log.e("2222222222", "name:" + b.getName());
                        Log.e("3333333333", "price"+b.getPrice());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
