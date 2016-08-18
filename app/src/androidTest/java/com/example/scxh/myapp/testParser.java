package com.example.scxh.myapp;

import android.test.AndroidTestCase;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by scxh on 2016/7/27.
 */
public class testParser extends AndroidTestCase {
    @Override
    protected void setUp() throws Exception {
        Log.e("66666666","setUp");
    }

    public void testDemo() throws Exception {
        Log.e("000000","testDemo");
        InputStream is=getContext().getAssets().open("books.xml");
        BookParse parser=new PullBookParser();
        ArrayList<book> book=( ArrayList<book>)parser.parse(is);
        Log.e("111111111111","testDemo");
        for(book b:book){
            Log.i("tag", book.toString());
            Log.e(">>>>>","name:"+b.getName());
        }
    }
}
