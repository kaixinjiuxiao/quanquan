package com.wealth.freedom.quanquan.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wealth.freedom.quanquan.fragment.HomeFragment;
import com.wealth.freedom.quanquan.fragment.UserFragment;

import java.util.ArrayList;

/**
 * Time : 2017/12/6
 * Describe :
 */

public class FragmentController {
    private int containerId;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments;

    private static FragmentController controller;
    private static boolean isReload;

    public static FragmentController getInstance(FragmentActivity activity, int containerId, boolean isReload) {
        FragmentController.isReload = isReload;
        if (controller == null) {
            controller = new FragmentController(activity, containerId);
        }
        return controller;
    }

    public static void onDestroy() {
        controller = null;
    }

    private FragmentController(FragmentActivity activity, int containerId) {
        this.containerId = containerId;
        fm = activity.getSupportFragmentManager();
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        if (isReload) {
            fragments.add(new HomeFragment());
            fragments.add(new UserFragment());
            FragmentTransaction ft = fm.beginTransaction();
            for (int i = 0; i < fragments.size(); i++) {
                ft.add(containerId, fragments.get(i), "" + i);
            }
            ft.commit();

        } else {
            for (int i = 0; i < 5; i++) {
                fragments.add( fm.findFragmentByTag(i+""));
            }
        }
    }

    public void showFragment(int position) {
        hideFragments();
        Fragment fragment = fragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();
        //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.show(fragment);
        ft.commitAllowingStateLoss();
    }

    public void hideFragments() {
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                ft.hide(fragment);
            }
        }
        ft.commitAllowingStateLoss();
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
}
