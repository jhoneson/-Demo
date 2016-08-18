package com.example.scxh.myapp.finfish.List;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scxh on 2016/8/10.
 */
public class AtyContainer {
    private AtyContainer() {}
    private static AtyContainer instance = new AtyContainer();
    private static List<Activity> activityStack = new ArrayList<Activity>();
    public static AtyContainer getInstance() {
        return instance;
    }
    public void addActivity(Activity activity){
        activityStack.add(activity);
    }
    public void RemoveAcitvity(Activity a){
        activityStack.remove(a);
    }
    public void FinishAllActivity(){
        if(activityStack!=null){
            for(int i=0;i<activityStack.size();i++){
                activityStack.get(i).finish();
            }
            activityStack.clear();
        }
    }
}
