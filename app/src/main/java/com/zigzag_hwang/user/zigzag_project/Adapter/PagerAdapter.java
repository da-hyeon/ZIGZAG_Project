package com.zigzag_hwang.user.zigzag_project.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zigzag_hwang.user.zigzag_project.Fragment.*;

public class PagerAdapter extends FragmentPagerAdapter
{

    private static int PAGE_NUMBER = 4;

    public PagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch ( i ){
            case 0:
                return SearchProduct.newInstance();
            case 1:
                return ShoppingMall.newInstance();
            case 2:
                return Collection.newInstance();
            case 3:
                return MyProduct.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch ( position ) {
            case 0:
                return "상품검색";
            case 1:
                return "쇼핑몰";
            case 2:
                return "모아보기";
            case 3:
                return "내상품";
            default:
                return null;
        }
    }
}
