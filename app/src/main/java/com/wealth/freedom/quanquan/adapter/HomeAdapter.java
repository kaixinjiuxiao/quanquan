package com.wealth.freedom.quanquan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/5 0005
 * Describe:
 */
public class HomeAdapter extends FragmentStatePagerAdapter {
    private final FragmentManager mFm;
    private List<Fragment> fragments;
    private List<String> mChannels;
    private int mChildCount;
    private boolean[] fragmentsUpdateFlag;

    public HomeAdapter(FragmentManager fm, List<Fragment> fragments, List<String> channels) {
        super(fm);
        mFm = fm;
        this.fragments = fragments;
        this.mChannels = channels;
    }

//    @Override
//    public BaseFragment getItem(int position) {
//        return fragments.get(position);
//    }

    @Override
    public int getCount() {
        return mChannels.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChannels == null ? "" : mChannels.get(position);
    }

//    @Override
//    public void notifyDataSetChanged() {
//        mChildCount = getCount();
//        super.notifyDataSetChanged();
//    }



    @Override
    public int getItemPosition(Object object) {
//        if (mChildCount > 0) {
//            mChildCount--;
        return POSITION_NONE;
//        }
//        return super.getItemPosition(object);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
}
