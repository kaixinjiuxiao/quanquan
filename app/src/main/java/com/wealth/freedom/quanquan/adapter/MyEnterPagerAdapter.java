package com.wealth.freedom.quanquan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wealth.freedom.quanquan.fragment.WaitExamineFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2017/10/28 0028
 * Describe:
 */
public class MyEnterPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"待审核", "审核中", "审核通过","审核失败"};
   private List<Fragment> mFragments;
    public MyEnterPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mFragments.add(new WaitExamineFragment());
        mFragments.add(new WaitExamineFragment());
        mFragments.add(new WaitExamineFragment());
        mFragments.add(new WaitExamineFragment());
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
