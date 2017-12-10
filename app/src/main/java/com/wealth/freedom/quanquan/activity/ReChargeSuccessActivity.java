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

public class ReChargeSuccessActivity extends BaseActivity {
    private ImageView mBack;
    private TextView mTitle,mDescribe;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_success);
        initView();
    }
    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("提现");
        mDescribe = (TextView) findViewById(R.id.describe);
        mDescribe.setText("您已经充值成功！");
    }
}
