package com.wealth.freedom.quanquan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wealth.freedom.quanquan.fragment.AllQAFragment;
import com.wealth.freedom.quanquan.fragment.MyAnswerFragment;
import com.wealth.freedom.quanquan.fragment.MyQusetionFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:  2017/10/28 0028
 * Describe:
 */
public class QuestionPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"全部提问", "我的提问", "我的问答"};
   private List<Fragment> mFragments;
    public QuestionPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mFragments.add(new AllQAFragment());
        mFragments.add(new MyQusetionFragment());
        mFragments.add(new MyAnswerFragment());
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
