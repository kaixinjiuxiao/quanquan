package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
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
 * Author : Captain
 * Time : 2017/12/3
 * Describe :
 */

public class ModifyPsActivity extends BaseActivity {
    private ImageView mBack;
    private TextView mTitle;
    private EditText mEdtOld,mEdtNew,mEdtAgain;
    private Button mBtnCommit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_ps);
        initView();
        initEvent();
    }

    private void initView() {
        mBack= (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("修改密码");
        mEdtOld= (EditText) findViewById(R.id.edtOldPs);
        mEdtNew= (EditText) findViewById(R.id.edtNewPs);
        mEdtAgain= (EditText) findViewById(R.id.edtNewPsAgain);
        mBtnCommit = (Button) findViewById(R.id.btnSure);
    }

    private void initEvent() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyPassword();
            }
        });
    }

    private void modifyPassword() {
        if(TextUtils.isEmpty(mEdtOld.getText().toString())){
            ToastUtils.showShort(ModifyPsActivity.this,"密码不能为空");
            return;
        }
        if(TextUtils.isEmpty(mEdtNew.getText().toString())){
            ToastUtils.showShort(ModifyPsActivity.this,"新密码不能为空");
            return;
        }
        if(TextUtils.isEmpty(mEdtAgain.getText().toString())){
            ToastUtils.showShort(ModifyPsActivity.this,"新密码不能为空");
            return;
        }

    }

}
