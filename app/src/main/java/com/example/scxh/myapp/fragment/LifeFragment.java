package com.example.scxh.myapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.scxh.myapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LifeFragment extends Fragment {
    private String str=null;
    public LifeFragment() {
        Log.e("LifeFragment()","构造方法");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("","onAttach>>>>>>>");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("","onCreate>>>>>>>");
        Bundle bundle=getArguments();
        str=bundle.getString("MESSAGE");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("","onCreateView>>>>>>>");
        View v=inflater.inflate(R.layout.fragment_life, container, false);
        TextView textView= (TextView) v.findViewById(R.id.fragment_life_txt);
        textView.setText(str);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("","onActivityCreated>>>>>>>");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("","onStart>>>>>>>");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("","onResume>>>>>>>");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("","onPause>>>>>>>");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("","onStop>>>>>>>");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("","onDestroy>>>>>>>");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("","onDestroyView>>>>>>>");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("","onDetach>>>>>>>");
    }
}
