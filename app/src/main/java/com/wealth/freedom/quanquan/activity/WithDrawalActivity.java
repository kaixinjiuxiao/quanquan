package com.wealth.freedom.quanquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wealth.freedom.quanquan.R;

/**
 * Time : 2017/12/4
 * Describe :
 */

public class WithDrawalActivity extends BaseActivity {
    private ImageView mBack;
    private Button mBtnSure;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_drawal);
        initView();
        initEvent();
    }

    private void initView() {
        mBack= (ImageView) findViewById(R.id.imgBack);
        mBtnSure = (Button) findViewById(R.id.btnSure);
    }

    private void initEvent() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WithDrawalActivity.this,WithDrawalSuccessActivity.class);
                startActivity(intent);
            }
        });
    }
}
