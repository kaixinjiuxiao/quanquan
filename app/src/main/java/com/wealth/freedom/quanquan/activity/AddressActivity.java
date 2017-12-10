package com.wealth.freedom.quanquan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.AddressAdapter;
import com.wealth.freedom.quanquan.entry.Address;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author : Captain
 * Time : 2017/12/4
 * Describe :
 */

public class AddressActivity extends BaseActivity implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    private ImageView mBack;
    private TextView mTitle;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private AddressAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<Address> mList = new ArrayList<>();
    private HashMap<Integer, Boolean> map = new HashMap<>();
    private RelativeLayout mLinearAddNew;
    private int page = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initView();
        initEvent();
    }
    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("收货地址");
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.pullLoadMore);
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setIsLoadMore(false);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        mLinearAddNew = (RelativeLayout) findViewById(R.id.linearAddNew);
        initData();
        mAdapter = new AddressAdapter(AddressActivity.this,mList,map);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    private void initEvent() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mLinearAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddressActivity.this,EditAddressActivity.class);
                startActivity(intent);
            }
        });
        mAdapter.setOnDeleteListener(new AddressAdapter.OnDeleteAddressListener() {
            @Override
            public void deleteAddress() {

            }
        });
        mAdapter.setOnEditListener(new AddressAdapter.OnEditAddresListener() {
            @Override
            public void editAddress() {

            }
        });
        mAdapter.setOnSettMOrenListener(new AddressAdapter.onSeetingMorenListener() {
            @Override
            public void seetMoren(int position) {

            }
        });
    }

    private void initData() {
        for (int i = 0; i <3 ; i++) {
            mList.add(new Address("张三","15000000000","湖南省长沙市雨花区万家丽街道",0));
            map.put(i, false);
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
