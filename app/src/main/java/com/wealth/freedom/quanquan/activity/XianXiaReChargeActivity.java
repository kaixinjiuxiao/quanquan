package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;

/**
 * Author : Captain
 * Time : 2017/12/5
 * Describe :
 */

public class XianXiaReChargeActivity extends BaseActivity {
    private ImageView mBack;
    private TextView mTitle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xx_recharge);
        init();
    }

    private void init() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("线下充值");
    }
}
