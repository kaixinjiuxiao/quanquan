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
 * Time:  2017/12/4 0004
 * Describe:
 */
public class DrawQuestionActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mBack;
    private TextView mTitle;
    private EditText mEdtQuestion;
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
        mTitle.setText("提问");
        mEdtQuestion = (EditText) findViewById(R.id.edtSuggestion);
        mEdtQuestion.setHint("您可以问趋势，聊热点，询个股......");
        mBtnCommit= (Button) findViewById(R.id.btnCommit);
    }

    private void initEvent() {
        mBack.setOnClickListener(this);
        mBtnCommit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                finish();
                break;
            case R.id.btnCommit:
                drawQuestion();
                break;
        }
    }

    private void drawQuestion() {
        if(TextUtils.isEmpty(mEdtQuestion.getText().toString())){
            ToastUtils.showShort(DrawQuestionActivity.this,"您可以问趋势，聊热点，询个股......");
            return;
        }
    }
}
