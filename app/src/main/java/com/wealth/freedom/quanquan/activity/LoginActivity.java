package com.wealth.freedom.quanquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;

/**
 * Author : Captain
 * Time : 2017/12/3
 * Describe :
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTitle;
    private TextView mRegister,mFindPs;
    private Button mBtnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }

    private void initView() {
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("登录");
        mRegister= (TextView) findViewById(R.id.txtRegister);
        mFindPs= (TextView) findViewById(R.id.txtFindPs);
        mBtnLogin= (Button) findViewById(R.id.btnLogin);
    }

    private void initEvent() {
        mRegister.setOnClickListener(this);
        mFindPs.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.txtRegister:
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.txtFindPs:
                intent.setClass(LoginActivity.this,FindPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLogin:
                intent.setClass(LoginActivity.this,MainActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }
    }
    public void aa(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setView(R.layout.layout_input_ps);
        AlertDialog dialog =builder.create();
        dialog.show();
    }
}
