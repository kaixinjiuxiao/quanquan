package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.fragment.OwnSelectFragment;
import com.wealth.freedom.quanquan.fragment.QuotationFragment;
import com.wealth.freedom.quanquan.utils.FragmentController2;

import java.util.ArrayList;
import java.util.List;

/**
 * Time : 2017/12/6
 * Describe :
 */

public class QuotationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mBack, mMore, mImgZX, mImgQu;
    private TextView mTitle, mTxtZX, mTxtQu;
    private LinearLayout mLinearZX, mLinearQu;
    private OwnSelectFragment mOwnSelectFragment;
    private QuotationFragment mQuotationFragment;
    private FragmentController2 mController2;
    private List<Fragment>mList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotation);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("自选");
        mTxtZX = (TextView) findViewById(R.id.txtZX);
        mTxtQu = (TextView) findViewById(R.id.txtQu);
        mMore = (ImageView) findViewById(R.id.imgMore);
        mMore.setVisibility(View.VISIBLE);
        mImgZX = (ImageView) findViewById(R.id.imgZX);
        mImgQu = (ImageView) findViewById(R.id.imgQu);
        mLinearZX = (LinearLayout) findViewById(R.id.linearZX);
        mLinearQu = (LinearLayout) findViewById(R.id.linearQu);
        mTxtZX.setSelected(true);
        mImgZX.setSelected(true);
        mOwnSelectFragment= new OwnSelectFragment();
        mQuotationFragment= new QuotationFragment();
        mList.add(mOwnSelectFragment);
        mList.add(mQuotationFragment);
        mController2 = FragmentController2.getInstance(this, R.id.content, true,mList);
        mController2.showFragment(0);
    }

    private void initEvent() {
        mBack.setOnClickListener(this);
        mMore.setOnClickListener(this);
        mLinearZX.setOnClickListener(this);
        mLinearQu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.imgMore:
                break;
            case R.id.linearZX:
                select();
                mTxtZX.setSelected(true);
                mImgZX.setSelected(true);
                mTitle.setText("自选");
                mController2.showFragment(0);
                break;
            case R.id.linearQu:
                select();
                mTxtQu.setSelected(true);
                mImgQu.setSelected(true);
                mTitle.setText("行情");
                mController2.showFragment(1);
                break;
        }
    }

    private void select() {
        mTxtZX.setSelected(false);
        mTxtQu.setSelected(false);
        mImgZX.setSelected(false);
        mImgQu.setSelected(false);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mController2.onDestroy();
    }
}
