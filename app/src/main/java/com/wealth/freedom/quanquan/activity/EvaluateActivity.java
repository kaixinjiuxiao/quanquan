package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;

/**
 * Time : 2017/12/5
 * Describe :
 */

public class EvaluateActivity extends BaseActivity {
    private ImageView mBack;
    private TextView mTitle;
    private AppCompatRatingBar mRatingBar;
    private EditText mEdtEvaluate;
    private Button mBtnCommit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("评价");
        mRatingBar = (AppCompatRatingBar) findViewById(R.id.raintBar);
        mEdtEvaluate = (EditText) findViewById(R.id.edtSuggestion);
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
                commitEvaluate();
            }
        });
    }

    private void commitEvaluate() {
        Log.e("tag","评价几分："+mRatingBar.getSecondaryProgress());
    }
}
