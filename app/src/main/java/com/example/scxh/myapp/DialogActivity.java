package com.example.scxh.myapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    public Button mProgress;
    public Button mDialog;
    public Button mSingleChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        mProgress= (Button) findViewById(R.id.progress_btn);
        mDialog= (Button) findViewById(R.id.dialog_btn);
        mSingleChoice= (Button) findViewById(R.id.singlechoice_btn);


        mProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        final ProgressDialog progressDialog = new ProgressDialog(DialogActivity.this);
                        progressDialog.setMessage("正在下载...");
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progressDialog.show();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 100; i++) {
                                    progressDialog.setProgress(i);
                                    SystemClock.sleep(100);
                                }
                                progressDialog.dismiss();
                            }
                        }).start();
                }
            });

        mDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("操作提示");
                builder.setMessage("是否退出");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"取消成功",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"成功退出",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("继续", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"选择成功",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog =builder.create();
                alertDialog.show();
            }
        });

        mSingleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("兴趣爱好");
                String[] singleChoices = new String[]{"读书","写字","唱歌","画画"};
                builder.setSingleChoiceItems(singleChoices, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"你选择是 "+which,Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"操作成功!",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"取消成功!",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog1 = builder.create();
                dialog1.show();
            }
        });
        }
    }

