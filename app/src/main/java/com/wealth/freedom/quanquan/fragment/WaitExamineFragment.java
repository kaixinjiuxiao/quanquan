package com.wealth.freedom.quanquan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.MyEnterAdapter;
import com.wealth.freedom.quanquan.entry.WaitExamine;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class WaitExamineFragment extends BaseFragment implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    private View mView;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private MyEnterAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<WaitExamine> mList = new ArrayList<>();
    private int page = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mView==null){
            mView=inflater.inflate(R.layout.fragment_my_enter,container,false);
            initView();
        }
        return mView;
    }

    private void initView() {
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) mView.findViewById(R.id.pullLoadMore);
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setIsLoadMore(false);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        initData();
        mAdapter = new MyEnterAdapter(getActivity(),mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i <2 ; i++) {
            mList.add(new WaitExamine("申请入驻企业版房间","待审核","2017-09-12 12:12:12"));
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
