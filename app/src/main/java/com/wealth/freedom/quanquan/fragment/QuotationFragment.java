package com.wealth.freedom.quanquan.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.adapter.HomeAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/7 0007
 * Describe:
 */
public class QuotationFragment extends BaseFragment {
    private View mView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mStringList = new ArrayList<>();
    private HomeAdapter mAdapter;
    private List<Fragment> mlist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mView==null){
            mView=inflater.inflate(R.layout.fragment_quotation,container,false);
            initView();
            initData();
        }
        return mView;
    }
    private void initView() {
        mTabLayout = (TabLayout) mView.findViewById(R.id.tabLayout);
        mViewPager = (ViewPager)mView. findViewById(R.id.viewpager);
        mStringList.add("沪深");
        mStringList.add("港股");
        mStringList.add("美股");
        HuShenFragment hushen = new HuShenFragment();
        HuShenFragment ganggu = new HuShenFragment();
        HuShenFragment meigu = new HuShenFragment();

        mlist.add(hushen);
        mlist.add(ganggu);
        mlist.add(meigu);
        mTabLayout.addTab(mTabLayout.newTab().setText(mStringList.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mStringList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mStringList.get(2)));
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabLayout, 30, 30);
            }
        });
    }
    private void initData() {
        mAdapter = new HomeAdapter(getChildFragmentManager(),mlist,mStringList);
        mViewPager.setAdapter(mAdapter);
        //   mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
        // mViewPager.setOffscreenPageLimit(1);
    }
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}
