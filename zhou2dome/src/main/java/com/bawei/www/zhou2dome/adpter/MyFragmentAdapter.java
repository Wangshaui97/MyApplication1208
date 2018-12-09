package com.bawei.www.zhou2dome.adpter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.www.zhou2dome.view.QRcodeFragment;
import com.bawei.www.zhou2dome.view.BannerlistFragment;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<Fragment> mlist = new ArrayList<>();
    private String[] tabs = new String[]{
            "首页","我的名片"
    };

    public MyFragmentAdapter(FragmentManager fm, Context context, List<Fragment> mlist) {
        super(fm);
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new BannerlistFragment();
            case 1:
                return new QRcodeFragment();
            default:
                return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
