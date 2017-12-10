package com.wealth.freedom.quanquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;

/**
 * Author : Captain
 * Time : 2017/12/3
 * Describe :
 */

public class ReChargeActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mBack,mAliPay,mWxPay;
    private TextView mNote;
    private RelativeLayout mRelativeOffLine,mRelativeCompany;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mNote = (TextView) findViewById(R.id.note);
        mRelativeOffLine = (RelativeLayout) findViewById(R.id.relativeXianXia);
        mRelativeCompany = (RelativeLayout) findViewById(R.id.relativeCompany);
        mAliPay = (ImageView) findViewById(R.id.imgAlipay);
        mAliPay.setSelected(true);
        mWxPay = (ImageView) findViewById(R.id.imgWxPay);
    }

    private void initEvent() {
        mBack.setOnClickListener(this);
        mNote.setOnClickListener(this);
        mAliPay.setOnClickListener(this);
        mWxPay.setOnClickListener(this);
        mRelativeOffLine.setOnClickListener(this);
        mRelativeCompany.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.imgBack:
                finish();
                break;
            case R.id.imgAlipay:
                mAliPay.setSelected(true);
                mWxPay.setSelected(false);
                break;
            case R.id.imgWxPay:
                mAliPay.setSelected(false);
                mWxPay.setSelected(true);
                break;
            case R.id.note:
                intent.setClass(ReChargeActivity.this,ReChargeNoteActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeXianXia:
                intent.setClass(ReChargeActivity.this,XianXiaReChargeActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeCompany:
                intent.setClass(ReChargeActivity.this,CompanyRecMoneyActivity.class);
                startActivity(intent);
                break;
        }
    }
}
