package com.example.scxh.myapp.slider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.scxh.myapp.R;
import com.example.scxh.myapp.WebViewActivity;
import com.example.scxh.myapp.fragment.MainFragmentActivity;

public class NewsFragment extends Fragment implements View.OnClickListener{
    private Button mPersontBtn,mVideoBtn,mNewsBtn,mPictureBtn;
    interface OnClickLisenler{
        void OnClick(View v);
    }
    private OnClickLisenler mOnClickLisenler;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.news_txt:
                startActivity(new Intent(getContext(), FragmentActivity.class));
                break;
            case R.id.pic_txt:
                startActivity(new Intent(getContext(), MainFragmentActivity.class));
                break;
            case R.id.person_txt:
                startActivity(new Intent(getContext(), WebViewActivity.class));
                break;
            case R.id.video_txt:
                break;
        }
        if(mOnClickLisenler!=null){
            mOnClickLisenler.OnClick(v);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnClickLisenler){
            mOnClickLisenler= (OnClickLisenler) context;
        }else {
            throw new ClassCastException("类型转换错误");
        }
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mNewsBtn= (Button)getView().findViewById(R.id.news_txt);
        mPersontBtn= (Button)getView().findViewById(R.id.person_txt);
        mVideoBtn= (Button)getView().findViewById(R.id.video_txt);
        mPictureBtn= (Button)getView().findViewById(R.id.pic_txt);

        mNewsBtn.setOnClickListener(this);
        mPersontBtn.setOnClickListener(this);
        mVideoBtn.setOnClickListener(this);
        mPictureBtn.setOnClickListener(this);
    }
}
