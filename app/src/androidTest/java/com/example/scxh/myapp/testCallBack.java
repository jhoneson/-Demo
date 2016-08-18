package com.example.scxh.myapp;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by scxh on 2016/7/27.
 */
public class testCallBack extends AndroidTestCase {

    public void testCallBack(){
        Employee employee = new Employee("员工A");

        employee.setOnCallBackInterface(new Employee.CallBackInterface() {
            @Override
            public void callMe(String message) {
                Log.e("","老板收到  ：" + message);
            }
        });

        employee.doUICode();
    }
}
