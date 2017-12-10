package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.fragment.GaiNianFragment;
import com.wealth.freedom.quanquan.fragment.HangYeFragment;

/**
 * Time : 2017/12/6
 * Describe :
 */

public class HotPlateActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mBack;
    private TextView mTitle,mHangYe,mGaiNian;
    private HangYeFragment mHangYeFrament;
    private GaiNianFragment mGaiNianFragmnt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_plate);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("热门板块");
        mHangYe = (TextView) findViewById(R.id.hangye);
        mGaiNian = (TextView) findViewById(R.id.gainian);
        mHangYe.setSelected(true);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(mHangYeFrament==null){
            mHangYeFrament= new HangYeFragment();
        }
        transaction.replace(R.id.content, mHangYeFrament);
        transaction.commit();
    }

    private void initEvent() {
        mBack.setOnClickListener(this);
        mHangYe.setOnClickListener(this);
        mGaiNian.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (view.getId()){
            case R.id.imgBack:
                finish();
                break;
            case R.id.hangye:
                mHangYe.setSelected(true);
                mGaiNian.setSelected(false);
                if(mHangYeFrament==null){
                    mHangYeFrament= new HangYeFragment();
                }
                transaction.replace(R.id.content, mHangYeFrament);
                transaction.commit();
                break;
            case R.id.gainian:
                mGaiNian.setSelected(true);
                mHangYe.setSelected(false);
                if(mGaiNianFragmnt==null){
                    mGaiNianFragmnt= new GaiNianFragment();
                }
                transaction.replace(R.id.content, mGaiNianFragmnt);
                transaction.commit();
                break;
        }
    }
}
