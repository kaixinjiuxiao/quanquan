package com.wealth.freedom.quanquan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.GaiNianAdapter;
import com.wealth.freedom.quanquan.entry.GaiNian;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2017/12/5 0005
 * Describe:
 */
public class HangYeFragment extends BaseFragment implements PullLoadMoreRecyclerView.PullLoadMoreListener{
    private View mView;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private GaiNianAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<GaiNian> mList = new ArrayList<>();
    private int page = 1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mView==null){
            mView=inflater.inflate(R.layout.fragment_gainian,container,false);
            initView();
        }
        return mView;
    }

    private void initView() {
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView)mView.findViewById(R.id.pullLoadMore);
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setIsLoadMore(false);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        initData();
        mAdapter = new GaiNianAdapter(getActivity(),mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mList.add(new GaiNian("稀缺资源","937746","2.80%","盐湖股份","","13.85 0.87%"));
        mList.add(new GaiNian("西藏","993611","2.39%","西藏矿业","","16.40 9.99%"));
        mList.add(new GaiNian("次新开板","994394","-2.09%","盐湖股份","","13.85 0.87%"));
        mList.add(new GaiNian("稀缺资源","937746","2.80%","盐湖股份","","13.85 0.87%"));
        mList.add(new GaiNian("稀缺资源","937746","2.80%","盐湖股份","","13.85 0.87%"));
        mList.add(new GaiNian("稀缺资源","937746","2.80%","盐湖股份","","13.85 0.87%"));
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
