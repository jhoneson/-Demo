package com.example.scxh.myapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.scxh.myapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsBlankFragment extends Fragment {
    private ListView listView;
    String[] arrays=new String[]{"新闻1","新闻2","新闻3","新闻4","新闻5"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_news_blank, container, false);
        ListView listView= (ListView) v.findViewById(R.id.fragment_test_list);
        ArrayAdapter adapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrays);
        listView.setAdapter(adapter);

        return v;
    }

}
