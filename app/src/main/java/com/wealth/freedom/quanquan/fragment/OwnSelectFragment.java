package com.wealth.freedom.quanquan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.activity.GuPiaoDetailsActivity;
import com.wealth.freedom.quanquan.adapter.OwnSelectAdapter;
import com.wealth.freedom.quanquan.adapter.OwnSelectAdapter2;
import com.wealth.freedom.quanquan.entry.OwnSelected;
import com.wealth.freedom.quanquan.entry.OwnSelected2;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2017/12/7 0007
 * Describe:
 */
public class OwnSelectFragment extends BaseFragment implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    private View mView;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private OwnSelectAdapter mAdapter;
    private OwnSelectAdapter2 mAdapter2;
    private RecyclerView mRecyclerView,mRecyclerViewHead;
    private List<OwnSelected> mList = new ArrayList<>();
    private List<OwnSelected2> mList2 = new ArrayList<>();
    private int page = 1;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        if(mView==null){
           mView = inflater.inflate(R.layout.fragment_own_select,container,false);
            initView();
            initEvent();
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
        mRecyclerViewHead = (RecyclerView) mView.findViewById(R.id.recycler);
        mRecyclerViewHead.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mAdapter2 = new OwnSelectAdapter2(getActivity(),mList2);
        mRecyclerViewHead.setAdapter(mAdapter2);
        initData();
        mAdapter = new OwnSelectAdapter(getActivity(),mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    private void initEvent() {
        mAdapter2.setItemClickListener(new OwnSelectAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), GuPiaoDetailsActivity.class);
                intent.putExtra("data",mList2.get(position).toString());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        mList.add(new OwnSelected("上证指数","000001","1277.69","0.87%",true));
        mList.add(new OwnSelected("宝塔实业","000595","10.29","2.09%",true));
        mList.add(new OwnSelected("深证燃气","601139","8.75","0.46%",true));
        mList.add(new OwnSelected("华胜天成","600410","10.23","-1.08%",false));
        mList2.add(new OwnSelected2("上证指数", "3353.82", "+1.90%", "+0.66", true));
        mList2.add(new OwnSelected2("上证指数", "3383.82", "-1.90", "-0.66", false));
        mList2.add(new OwnSelected2("上证指数", "3353.82", "+1.90%", "+0.66", true));
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
