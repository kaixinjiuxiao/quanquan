package com.wealth.freedom.quanquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.fragment.HomeFragment;
import com.wealth.freedom.quanquan.fragment.UserFragment;
import com.wealth.freedom.quanquan.utils.FragmentController;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mUser,mQuAnsw,mEnter,mHome,mHangQ;
    private TextView mHQ,mRZ,mWD,mMY;
    private ImageView mImgHQ,mImgRZ,mImgWD,mImgMy;
    private UserFragment mUserFragment;
    private HomeFragment mHomeFragment;
    private FragmentController mFragmentController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        mUser = (LinearLayout) findViewById(R.id.lineaUser);
        mQuAnsw = (LinearLayout) findViewById(R.id.linearQa);
        mEnter = (LinearLayout) findViewById(R.id.linearEnter);
        mHome = (LinearLayout) findViewById(R.id.linearHome);
        mHangQ = (LinearLayout) findViewById(R.id.linearHQ);
        mHQ = (TextView) findViewById(R.id.txtHQ);
        mRZ = (TextView) findViewById(R.id.txtRZ);
        mWD = (TextView) findViewById(R.id.txtWD);
        mMY = (TextView) findViewById(R.id.txtMy);
        mImgHQ = (ImageView) findViewById(R.id.imgHQ);
        mImgRZ = (ImageView) findViewById(R.id.imgRZ);
        mImgWD = (ImageView) findViewById(R.id.imgWD);
       mImgMy = (ImageView) findViewById(R.id.imgMy);
        mFragmentController = FragmentController.getInstance(this, R.id.content, true);
      mFragmentController.showFragment(0);
    }

    private void initEvent() {
        mUser.setOnClickListener(this);
        mQuAnsw.setOnClickListener(this);
        mEnter.setOnClickListener(this);
        mHome.setOnClickListener(this);
        mHangQ.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linearHome:
                selected();
                mFragmentController.showFragment(0);
                break;
            case R.id.lineaUser:
                mMY.setSelected(true);
                mImgMy.setSelected(true);
                mFragmentController.showFragment(1);
                break;
            case R.id.linearEnter:
                Intent intent = new Intent(MainActivity.this,EnterQuanQUanActivity.class);
                startActivity(intent);
                break;
            case R.id.linearQa:
                Intent intent2 = new Intent(MainActivity.this,QuAnswerActivity.class);
                startActivity(intent2);
                break;
            case R.id.linearHQ:
                Intent intent3 = new Intent(MainActivity.this,QuotationActivity.class);
                startActivity(intent3);
                break;
        }
    }

    public void selected(){
        mHQ.setSelected(false);
        mRZ.setSelected(false);
        mWD.setSelected(false);
        mMY.setSelected(false);
        mImgHQ.setSelected(false);
        mImgRZ.setSelected(false);
        mImgWD.setSelected(false);
        mImgMy.setSelected(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFragmentController.onDestroy();
    }
}
