package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;

/**
 * Author : Captain
 * Time : 2017/12/4
 * Describe :
 */

public class EditAddressActivity extends BaseActivity {
    private ImageView mBack;
    private TextView mTitle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("收货地址");
    }

    private void initEvent() {
    }
}
