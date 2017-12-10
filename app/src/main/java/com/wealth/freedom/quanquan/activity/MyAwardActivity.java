package com.wealth.freedom.quanquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.MyAwardAdapter;
import com.wealth.freedom.quanquan.entry.MyAward;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Time : 2017/12/3
 * Describe :
 */

public class MyAwardActivity extends BaseActivity implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    private ImageView mBack;
    private TextView mTitle;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private MyAwardAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<MyAward> mList = new ArrayList<>();
    private int page = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_award);
        initView();
        initEvent();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("我的奖品");
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.pullLoadMore);
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setIsLoadMore(false);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        initData();
        mAdapter = new MyAwardAdapter(MyAwardActivity.this,mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    private void initEvent() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mAdapter.setOnReceiveListener(new MyAwardAdapter.OnReceiveListener() {
            @Override
            public void receive() {
                Intent intent =new Intent(MyAwardActivity.this,AddressActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        for (int i = 0; i <3 ; i++) {
            mList.add(new MyAward("","Apple iPhone 8 Plus 64GB 金色","数量：x1"));
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
