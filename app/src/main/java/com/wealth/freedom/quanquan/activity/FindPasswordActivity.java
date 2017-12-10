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

public class FindPasswordActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mBack;
    private EditText mEdtPhone,mEdtCode,mEdtPs;
    private TextView mTxtCode,mTitle;
    private Button mBtnSure;
    public static int UPDATE = 60;
    private boolean canClick = true;
    private static Runnable mRun;
    private static Handler mHandler =new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_ps);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("找回密码");
        mEdtPhone = (EditText) findViewById(R.id.edtPhone);
        mEdtCode = (EditText) findViewById(R.id.edtCode);
        mEdtPs = (EditText) findViewById(R.id.edtPassword);
        mTxtCode = (TextView) findViewById(R.id.txtCode);
        mBtnSure = (Button) findViewById(R.id.btnSure);
    }

    private void initEvent() {
        mBack.setOnClickListener(this);
        mTxtCode.setOnClickListener(this);
        mBtnSure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBack:
                finish();
                break;
            case R.id.txtCode:
                getVerificationCode();
                break;
            case R.id.btnSure:
                resetPassword();
                break;
            default:
                break;
        }
    }

    /**
     * 获取验证码
     */
    private void getVerificationCode() {
        if(TextUtils.isEmpty(mEdtPhone.getText().toString())){
            ToastUtils.showShort(this,"手机号码不能为空");
            return;
        }
        if(canClick){
            startTime();

        }else{
            ToastUtils.showShort(this,"正在发送中");
        }

    }

    private void startTime(){
        canClick=false;
        mRun = new Runnable() {
            @Override
            public void run() {
                mTxtCode.setText(UPDATE--+"");
                if(UPDATE==0){
                    mTxtCode.setClickable(true);
                    mTxtCode.setText("发送验证码");
                    UPDATE = 60;
                    canClick = true;
                }else{
                    mHandler.postDelayed(this,1000);
                }
            }
        };
        mHandler.post(mRun);
    }

    /**
     * 重新设置密码
     */
    private void resetPassword() {
        if(TextUtils.isEmpty(mEdtPhone.getText().toString())){
            ToastUtils.showShort(this,"手机号码不能为空");
            return;
        }
        if(TextUtils.isEmpty(mEdtCode.getText().toString())){
            ToastUtils.showShort(this,"验证码不能为空");
            return;
        }
        if(TextUtils.isEmpty(mEdtPs.getText().toString())){
            ToastUtils.showShort(this,"密码不能为空");
            return;
        }
        ToastUtils.showShort(this,"修改成功");
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mRun);
        UPDATE=60;
    }
}
