package com.zigzag_hwang.user.zigzag_project.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zigzag_hwang.user.zigzag_project.Adapter.PagerAdapter;
import com.zigzag_hwang.user.zigzag_project.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapter mPageAdapter = new PagerAdapter(getSupportFragmentManager());

        ViewPager mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mPageAdapter);

        TabLayout mTab = (TabLayout) findViewById(R.id.tabs);
        mTab.setupWithViewPager(mViewPager);
        mTab.getTabAt(0).setIcon(R.drawable.baseline_search_white_18dp);
        mTab.getTabAt(1).setIcon(R.drawable.baseline_home_white_18dp);
        mTab.getTabAt(2).setIcon(R.drawable.hanger_icon);
        mTab.getTabAt(3).setIcon(R.drawable.baseline_favorite_border_white_18dp);

    }
}
