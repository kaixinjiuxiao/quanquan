package com.wealth.freedom.quanquan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.activity.AttentionActivity;
import com.wealth.freedom.quanquan.activity.DrawAwardActivity;
import com.wealth.freedom.quanquan.activity.ModifyPsActivity;
import com.wealth.freedom.quanquan.activity.MyAwardActivity;
import com.wealth.freedom.quanquan.activity.MyEnterActivity;
import com.wealth.freedom.quanquan.activity.NoticeActivity;
import com.wealth.freedom.quanquan.activity.QianDaoActivity;
import com.wealth.freedom.quanquan.activity.ReChargeActivity;
import com.wealth.freedom.quanquan.activity.SettingActivity;
import com.wealth.freedom.quanquan.activity.SuggestionActivity;
import com.wealth.freedom.quanquan.activity.UserInfoActivity;
import com.wealth.freedom.quanquan.activity.WithDrawalActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author : Captain
 * Time : 2017/12/3
 * Describe :
 */

public class UserFragment extends BaseFragment implements View.OnClickListener {
    private View mView;
    private TextView mTitle,mUserName,mUserLevel,mBanlance;
    private CircleImageView mPortrait;
    private LinearLayout mLinearChongzhi,mLinearTx;
    private RelativeLayout mRelativeInfo,mRelativeQD,mRelativeMdf,mRelativeAtten,mRelativeDraw,mRelativeAward
            ,mRelativeEnter,mRelativeSugg,mRelativeSett,mRelativeNotice;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        if(mView==null){
            mView = inflater.inflate(R.layout.fragment_user,container,false);
            initView();
            initEvent();
        }
        return mView;
    }

    private void initView() {
        mTitle = (TextView) mView.findViewById(R.id.txtTitle);
        mTitle.setText("个人中心");
        mUserName = (TextView) mView.findViewById(R.id.txtUserName);
        mUserLevel = (TextView) mView.findViewById(R.id.txtUserLevel);
        mBanlance = (TextView) mView.findViewById(R.id.txtBanlance);
        mPortrait= (CircleImageView) mView.findViewById(R.id.imgUser);
        mLinearChongzhi = (LinearLayout) mView.findViewById(R.id.linearChongzhi);
        mLinearTx = (LinearLayout) mView.findViewById(R.id.linearTx);
        mRelativeInfo = (RelativeLayout) mView.findViewById(R.id.relativeInfo);
        mRelativeQD = (RelativeLayout) mView.findViewById(R.id.relativeQd);
        mRelativeMdf = (RelativeLayout) mView.findViewById(R.id.relativeMdf);
        mRelativeAtten = (RelativeLayout) mView.findViewById(R.id.relativeAtten);
        mRelativeDraw = (RelativeLayout) mView.findViewById(R.id.relativeDraw);
        mRelativeAward = (RelativeLayout) mView.findViewById(R.id.relativeAward);
        mRelativeEnter = (RelativeLayout) mView.findViewById(R.id.relativeEnter);
        mRelativeSugg = (RelativeLayout) mView.findViewById(R.id.relativeSuggest);
        mRelativeSett = (RelativeLayout) mView.findViewById(R.id.relativeSeeting);
        mRelativeNotice = (RelativeLayout) mView.findViewById(R.id.relativeNotice);
    }

    private void initEvent() {
        mLinearChongzhi.setOnClickListener(this);
        mLinearTx.setOnClickListener(this);
        mRelativeInfo.setOnClickListener(this);
        mRelativeQD.setOnClickListener(this);
        mRelativeMdf.setOnClickListener(this);
        mRelativeAtten.setOnClickListener(this);
        mRelativeDraw.setOnClickListener(this);
        mRelativeAward.setOnClickListener(this);
        mRelativeEnter.setOnClickListener(this);
        mRelativeSugg.setOnClickListener(this);
        mRelativeSett.setOnClickListener(this);
        mRelativeNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.linearChongzhi:
                intent.setClass(getActivity(),ReChargeActivity.class);
                startActivity(intent);
                break;
            case R.id.linearTx:
                intent.setClass(getActivity(),WithDrawalActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeInfo:
                intent.setClass(getActivity(),UserInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeQd:
                intent.setClass(getActivity(),QianDaoActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeMdf:
                intent.setClass(getActivity(),ModifyPsActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeAtten:
                intent.setClass(getActivity(), AttentionActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeDraw:
                intent.setClass(getActivity(),DrawAwardActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeAward:
                intent.setClass(getActivity(),MyAwardActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeEnter:
                intent.setClass(getActivity(),MyEnterActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeSuggest:
                intent.setClass(getActivity(),SuggestionActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeSeeting:
                intent.setClass(getActivity(),SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeNotice:
                intent.setClass(getActivity(),NoticeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
