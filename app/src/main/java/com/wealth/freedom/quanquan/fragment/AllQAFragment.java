package com.wealth.freedom.quanquan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.activity.DrawQuestionActivity;
import com.wealth.freedom.quanquan.activity.HuiDaDetailsTwoActivity;
import com.wealth.freedom.quanquan.adapter.AllQuesAnswAdapter;
import com.wealth.freedom.quanquan.entry.AllQuestionAnswer;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class AllQAFragment extends BaseFragment implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    private View mView;
    private LinearLayout mLinearTiWen;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private AllQuesAnswAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<AllQuestionAnswer> mList = new ArrayList<>();
    private int page = 1;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        if(mView==null){
            mView=inflater.inflate(R.layout.fragment_qa,container,false);
            initView();
            initEvent();
        }
        return mView;
    }

    private void initView() {
        mLinearTiWen = (LinearLayout) mView.findViewById(R.id.linearTiWen);
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) mView.findViewById(R.id.pullLoadMore);
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        initData();
        mAdapter = new AllQuesAnswAdapter(getActivity(),mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i <2 ; i++) {
            mList.add(new AllQuestionAnswer("","荼蘼之恋(230453444)","2017-11-29 20:51:30 3天前更新","回答数：2","老师，给看看002638以前停盘，今天开盘跌停，怎 么个情况…"));
        }
    }

    private void initEvent() {
        mLinearTiWen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DrawQuestionActivity.class);
                startActivity(intent);
            }
        });
        mAdapter.setOnItemClickLitener(new AllQuesAnswAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(getActivity(), HuiDaDetailsTwoActivity.class));
            }
        });
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
