package com.wealth.freedom.quanquan.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.MyQuestionAdapter;
import com.wealth.freedom.quanquan.entry.MyQuestion;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class MyQusetionFragment extends BaseFragment implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    private View mView;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private MyQuestionAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<MyQuestion> mList = new ArrayList<>();
    private int page = 1;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        if(mView==null){
            mView=inflater.inflate(R.layout.fragment_qa_two,container,false);
            initView();
        }
        return mView;
    }

    private void initView() {
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) mView.findViewById(R.id.pullLoadMore);
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        initData();
        mAdapter = new MyQuestionAdapter(getActivity(),mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i <2 ; i++) {
            mList.add(new MyQuestion("2017-11-29 20:51:30","回答数：5","老师，给看看002638以前停盘，今天开盘跌停，怎么个情况 求解答…"));
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
