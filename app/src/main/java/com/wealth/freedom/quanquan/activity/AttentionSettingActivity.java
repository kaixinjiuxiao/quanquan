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

public class AttentionSettingActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mBack,mAdd,mFall,mThan;
    private TextView mTitle;
    private boolean add =false;
    private boolean fall=false;
    private boolean than=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention_setting);
        initView();
        initEvent();
    }

    private void initView() {
        mBack= (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle= (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("提醒设置");
        mAdd = (ImageView) findViewById(R.id.imgAdd);
        mFall = (ImageView) findViewById(R.id.imgFall);
        mThan = (ImageView) findViewById(R.id.imgThan);
        mAdd.setBackgroundResource(R.drawable.guan);
        mFall.setBackgroundResource(R.drawable.guan);
        mThan.setBackgroundResource(R.drawable.guan);
    }

    private void initEvent() {
        mBack.setOnClickListener(this);
        mAdd.setOnClickListener(this);
        mFall.setOnClickListener(this);
        mThan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBack:
                finish();
                break;
            case R.id.imgAdd:
                if(add==true){
                    mAdd.setBackgroundResource(R.drawable.guan);
                    add=false;
                }else{
                    mAdd.setBackgroundResource(R.drawable.kai);
                    add=true;
                }
                break;
            case R.id.imgFall:
                if(fall==true){
                    mFall.setBackgroundResource(R.drawable.guan);
                    fall=false;
                }else{
                    mFall.setBackgroundResource(R.drawable.kai);
                    fall=true;
                }
                break;
            case R.id.imgThan:
                if(than==true){
                    mThan.setBackgroundResource(R.drawable.guan);
                    than=false;
                }else{
                    mThan.setBackgroundResource(R.drawable.kai);
                    than=true;
                }
                break;
        }
    }


}
