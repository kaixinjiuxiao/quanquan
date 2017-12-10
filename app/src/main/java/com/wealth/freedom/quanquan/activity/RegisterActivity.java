package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.utils.ToastUtils;

/**
 * Time : 2017/12/3
 * Describe :
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    public static int UPDATE = 60;
    private boolean canClick = true;
    private static Runnable mRun;
    private static Handler mHandler = new Handler();
    private ImageView mBack;
    private TextView mTitle, mSendCode, mAgree, mLogin;
    private EditText mEdtPhone, mEdtCode, mEdtPassword;
    private Button mBtnRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initEvent();
    }
    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("注册");
        mEdtPhone = (EditText) findViewById(R.id.edtPhone);
        mEdtCode = (EditText) findViewById(R.id.edtCode);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mSendCode = (TextView) findViewById(R.id.txtCode);
        mAgree = (TextView) findViewById(R.id.txtAggrement);
        mLogin = (TextView) findViewById(R.id.txtLogin);
        mBtnRegister = (Button) findViewById(R.id.btnRegister);
    }

    private void initEvent() {
        mBack.setOnClickListener(this);
        mSendCode.setOnClickListener(this);
        mAgree.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.txtCode:
                getVerificationCode();
                break;
            case R.id.txtAggrement:
                break;
            case R.id.txtLogin:
                finish();
                break;
            case R.id.btnRegister:
                register();
                break;
            default:
                break;
        }
    }

    /**
     * 获取验证码
     */
    private void getVerificationCode() {
        if (TextUtils.isEmpty(mEdtPhone.getText().toString())) {
            ToastUtils.showShort(this, "手机号码不能为空");
            return;
        }
        if (canClick) {
            startTime();

        }

    }

    private void startTime() {
        canClick = false;
        mRun = new Runnable() {
            @Override
            public void run() {
                mSendCode.setText(UPDATE-- + "");
                if (UPDATE == 0) {
                    mSendCode.setClickable(true);
                    mSendCode.setText("发送验证码");
                    UPDATE = 60;
                    canClick = true;
                } else {
                    mHandler.postDelayed(this, 1000);
                }
            }
        };
        mHandler.post(mRun);
    }

    /**
     * 用户注册
     */
    private void register() {
        if (TextUtils.isEmpty(mEdtPhone.getText().toString())) {
            ToastUtils.showShort(this, "手机号码不能为空");
            return;
        }
        if (TextUtils.isEmpty(mEdtCode.getText().toString())) {
            ToastUtils.showShort(this, "验证码不能为空");
            return;
        }
        if (TextUtils.isEmpty(mEdtPassword.getText().toString())) {
            ToastUtils.showShort(this, "密码不能为空");
            return;
        }
        ToastUtils.showShort(this, "注册成功");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mRun);
        UPDATE = 60;
    }
}
