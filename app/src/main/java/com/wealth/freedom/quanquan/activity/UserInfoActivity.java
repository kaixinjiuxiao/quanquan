package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author : Captain
 * Time : 2017/12/3
 * Describe :
 */

public class UserInfoActivity extends BaseActivity {
    private ImageView mBack;
    private CircleImageView mPortrait;
    private TextView mTitle,mNickName,mTrueName,mAge,mAddress,mPhone,mQQ,mWXId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("个人资料");
        mPortrait= (CircleImageView) findViewById(R.id.imgUser);
        mNickName = (TextView) findViewById(R.id.nickName);
        mTrueName = (TextView) findViewById(R.id.trueName);
        mAge = (TextView) findViewById(R.id.age);
        mAddress = (TextView) findViewById(R.id.address);
        mPhone = (TextView) findViewById(R.id.phone);
        mQQ = (TextView) findViewById(R.id.qq);
        mWXId = (TextView) findViewById(R.id.wxId);
    }

    private void initData() {
    }

    private void initEvent() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
