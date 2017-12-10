package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.AttentionAdapter;
import com.wealth.freedom.quanquan.entry.AttentionHouse;
import com.wealth.freedom.quanquan.utils.ToastUtils;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Time : 2017/12/3
 * Describe :
 */

public class AttentionActivity extends BaseActivity implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    private ImageView mBack;
    private TextView mTitle;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private AttentionAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<AttentionHouse> mList = new ArrayList<>();
    private int page = 1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_attention);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("我关注的房间");
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView)findViewById(R.id.pullLoadMore);
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setIsLoadMore(false);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        initData();
        mAdapter = new AttentionAdapter(AttentionActivity.this,mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    private void initEvent() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mAdapter.setCancelAttentionListener(new AttentionAdapter.OnCancelAttentionListener() {
            @Override
            public void cancelAttention(int position) {
                ToastUtils.showShort(AttentionActivity.this,"取消成功");
            }
        });
    }

    private void initData() {
        for (int i = 0; i <2 ; i++) {
            mList.add(new AttentionHouse("","无白丁学院 李春雷老师","独家讲解股票行情市场"));
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
