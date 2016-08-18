package com.example.scxh.myapp.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.scxh.myapp.R;

public class FragmentLifeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button addBtn,removeBtn,replaceBtn,bundleBtn;
    private LifeFragment lifeFragment;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life);

        addBtn= (Button) findViewById(R.id.fragment_add);
        removeBtn= (Button) findViewById(R.id.fragment_remove);
        replaceBtn= (Button) findViewById(R.id.fragment_replace);
        bundleBtn= (Button) findViewById(R.id.fragment_bundle_msg);
        editText= (EditText) findViewById(R.id.fragment_edit_txt);

        addBtn.setOnClickListener(this);
        removeBtn.setOnClickListener(this);
        replaceBtn.setOnClickListener(this);
        bundleBtn.setOnClickListener(this);
        editText.setOnClickListener(this);

        lifeFragment=new LifeFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_add:
                Log.e("","fragment_add");
                addFragment();
                break;
            case R.id.fragment_remove:
                Log.e("","fragment_remove");
                removeFragment();
                break;
            case R.id.fragment_replace:
                Log.e("","fragment_replace");
                replaceFragment();
                break;
            case R.id.fragment_bundle_msg:
                bundleMessage();
                break;
        }
    }
    public void addFragment(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_life_show, lifeFragment).commit();
    }
    public void removeFragment(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.remove(lifeFragment).commit();
    }
    public void replaceFragment(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_life_show,new NewsBlankFragment()).commit();
    }
    public void bundleMessage(){
        Bundle bundle=new Bundle();
        String msg=editText.getText().toString();
        bundle.putString("MESSAGE",msg);
        lifeFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_life_show,lifeFragment).commit();
        editText.setText("");
    }

}
