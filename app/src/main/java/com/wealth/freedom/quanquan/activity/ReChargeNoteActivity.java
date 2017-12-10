package com.wealth.freedom.quanquan.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.ReChargeNoteAdapter;
import com.wealth.freedom.quanquan.entry.ReChargeNote;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Time : 2017/12/4
 * Describe :
 */

public class ReChargeNoteActivity extends BaseActivity implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    private ImageView mBack;
    private TextView mTitle;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private ReChargeNoteAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<ReChargeNote> mList = new ArrayList<>();
    private int page = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_note);
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("充值记录");
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView)findViewById(R.id.pullLoadMore);
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setIsLoadMore(false);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        initData();
        mAdapter = new ReChargeNoteAdapter(ReChargeNoteActivity.this,mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mList.add(new ReChargeNote("2017-12-01","100","已入账"));
        mList.add(new ReChargeNote("2017-12-01","100","待入账"));
        mList.add(new ReChargeNote("2017-12-01","100","已入账"));
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
