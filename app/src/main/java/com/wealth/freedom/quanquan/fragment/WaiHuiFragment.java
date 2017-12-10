package com.wealth.freedom.quanquan.fragment;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.ZhiBoAdapter;
import com.wealth.freedom.quanquan.entry.ZhiBo;
import com.wealth.freedom.quanquan.utils.ToastUtils;
import com.wealth.freedom.quanquan.view.PasswordInputView;
import com.wealth.freedom.quanquan.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/5 0005
 * Describe:
 */
public class WaiHuiFragment extends BaseFragment implements PullLoadMoreRecyclerView.PullLoadMoreListener, View.OnClickListener {
    private View mView;
    private TextView txt;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private ZhiBoAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<ZhiBo> mList = new ArrayList<>();
    private int page = 1;
    private PasswordInputView mInput;
    private AlertDialog mDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView==null){
            mView = inflater.inflate(R.layout.fragment_common,container,false);
            init();
            initEvent();
        }
        return mView;
    }

    private void init() {
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView)mView.findViewById(R.id.pullLoadMore);
        mRecyclerView = mPullLoadMoreRecyclerView.getRecyclerView();
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setIsLoadMore(false);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
        initData();
        mAdapter = new ZhiBoAdapter(getActivity(),mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }
    private void initEvent() {
        mAdapter.setLookingListener(new ZhiBoAdapter.OnLookingListener() {
            @Override
            public void onLooking(int position) {
                displayDialog();
            }
        });
        mAdapter.setAcctntionListener(new ZhiBoAdapter.OnAcctntionListener() {
            @Override
            public void attentionHouse(int position) {
                ToastUtils.showShort(getActivity(),"开启关注");
            }
        });
    }
    private void initData() {
        mList.add(new ZhiBo("","","无白丁学院 李村雷老师--《早盘看点》","无白丁学院 913人观看",1));
        mList.add(new ZhiBo("","","和靠谱的人一起聊股票","点掌财经 913人观看",0));
        mList.add(new ZhiBo("","","和靠谱的人一起聊股票","点掌财经 913人观看",1));
        mList.add(new ZhiBo("","","和靠谱的人一起聊股票","点掌财经 913人观看",0));
    }

    @Override
    public void onRefresh() {
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void onLoadMore() {
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
    }

    private void displayDialog() {
        final AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_input_ps,null);
        builder.setView(view);
        mInput = (PasswordInputView) view.findViewById(R.id.inputPassword);
        TextView sure = (TextView) view.findViewById(R.id.sure);
        TextView cancel = (TextView) view.findViewById(R.id.cancel);
        sure.setOnClickListener(this);
        cancel.setOnClickListener(this);
        mDialog = builder.create();
        mDialog.show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sure:
                ToastUtils.showShort(getActivity(),"请输入密码");
                break;
            case R.id.cancel:
                mDialog.dismiss();
                break;
            default:
                break;
        }
    }
}
