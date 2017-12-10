package com.wealth.freedom.quanquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;

/**
 * Time:  2017/12/8 0008
 * Describe:
 */
public class GuPiaoDetailsActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mBack,mImgRe,mImgDe;
    private TextView mTitle,mTxtRe,mTxtDe;
    private LinearLayout mLinearRe,mLinearDe;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gupiao_details);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTxtRe = (TextView) findViewById(R.id.txtRe);
        mTxtDe = (TextView) findViewById(R.id.txtDe);
        mImgRe = (ImageView) findViewById(R.id.imgRe);
        mImgDe = (ImageView) findViewById(R.id.imgDe);
        mLinearRe = (LinearLayout) findViewById(R.id.linearRemind);
        mLinearDe = (LinearLayout) findViewById(R.id.linearDelete);
    }

    private void initEvent() {
        mBack.setOnClickListener(this);
        mLinearRe.setOnClickListener(this);
        mLinearDe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBack:
                finish();
                break;
            case R.id.linearRemind:

                Intent intent = new Intent(this,AttentionSettingActivity.class);
                startActivity(intent);
                break;
            case R.id.linearDelete:

                break;
                 default:
                     break;
        }
    }
}
