package com.wealth.freedom.quanquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.HDDetialsOneAdapter;
import com.wealth.freedom.quanquan.entry.HuiDaDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Time : 2017/12/5
 * Describe :
 */

public class HuiDaDetailsTwoActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mBack;
    private TextView mTitle, mTxtPL;
    private RecyclerView mPingLun;
    private List<HuiDaDetails> mList =new ArrayList<>();
    private HDDetialsOneAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huida_one);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("回答详情");
        mTxtPL = (TextView) findViewById(R.id.txtRight);
        mTxtPL.setText("评价");
        mTxtPL.setVisibility(View.VISIBLE);
        mPingLun = (RecyclerView) findViewById(R.id.recyclerPl);
        mPingLun.setLayoutManager(new LinearLayoutManager(this));
        initData();
        mPingLun.setAdapter(new HDDetialsOneAdapter(this,mList));
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            mList.add(new HuiDaDetails("","荼蘼(230453444)","2017-11-29 20:51:30","非常好，点评的很精彩"));
        }
    }

    private void initEvent() {
        mBack.setOnClickListener(this);
        mTxtPL.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.txtRight:
                Intent intent = new Intent(HuiDaDetailsTwoActivity.this, EvaluateActivity.class);
                startActivity(intent);
                break;
        }
    }
}
