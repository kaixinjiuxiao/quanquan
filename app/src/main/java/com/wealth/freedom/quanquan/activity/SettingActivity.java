package com.wealth.freedom.quanquan.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;

/**
 * Time : 2017/12/3
 * Describe :
 */

public class SettingActivity extends BaseActivity {
    private ImageView mBack;
    private TextView mTitle,mVersion;
    private Button mBtnExit;
    private RelativeLayout mRelativeVersion;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeting);
        initView();
        initEvent();
    }

    private void initView() {
        mBack= (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("设置");
        mVersion = (TextView) findViewById(R.id.txtVersion);
        mRelativeVersion = (RelativeLayout) findViewById(R.id.relativeVersion);
        mBtnExit= (Button) findViewById(R.id.btnLoginOut);
    }

    private void initEvent() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRelativeVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayExitDialog();
            }
        });
    }

    private void displayExitDialog() {
        AlertDialog.Builder builder= new AlertDialog.Builder(SettingActivity.this);
        builder.setTitle("退出");
        builder.setMessage("您真的要退出吗？");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog= builder.create();
        dialog.show();
    }
}
