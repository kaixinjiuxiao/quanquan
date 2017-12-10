package com.wealth.freedom.quanquan.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.view.MZBannerView;
import com.wealth.freedom.quanquan.view.MZHolderCreator;
import com.wealth.freedom.quanquan.view.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Time : 2017/12/4
 * Describe :
 */

public class EnterQuanQUanActivity extends BaseActivity {
    private ImageView mBack;
    private TextView mTitle;
    private MZBannerView mMZBannerView;
    private List<String >mList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_quan);
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.imgBack);
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("入驻圈圈");
        mMZBannerView = (MZBannerView) findViewById(R.id.banber);
        mList.add("http://img1.3lian.com/2015/a1/95/d/105.jpg");
        mList.add("http://img.taopic.com/uploads/allimg/130331/240460-13033106243430.jpg");
        mList.add("http://img1.3lian.com/2015/a1/46/d/198.jpg");
        setPages(mList);
    }

    private void setPages(List<String> list) {
        mMZBannerView.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

        mMZBannerView.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMZBannerView.pause();
    }
    public static class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.remote_banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.remote_item_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            Log.e("tag","当前位置"+position);
            Glide.with(context).load(data).into(mImageView);
        }
    }
}
