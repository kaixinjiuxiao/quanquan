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
 * Time : 2017/12/3
 * Describe :
 */

public class SuggestionActivity extends BaseActivity {
    private ImageView mBack;
    private TextView mTitle;
    private EditText mEdtSugges;
    private Button mBtnCommit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("意见反馈");
        mEdtSugges = (EditText) findViewById(R.id.edtSuggestion);
        mBtnCommit = (Button) findViewById(R.id.btnCommit);
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
                commitSuggest();
            }
        });
    }

    private void commitSuggest() {
        if(TextUtils.isEmpty(mEdtSugges.getText().toString())){
            ToastUtils.showShort(SuggestionActivity.this,"请输入您的意见和建议，已方便我们改进～");
            return;
        }
    }
}
