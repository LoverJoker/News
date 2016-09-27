package com.example.joker.news;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

import Adapter.MainTabAdapter;
import Fragment.FirstPagerFragment;

/**
 * Created by Joker on 2016/9/26.
 */

public class Main_Activity extends AppCompatActivity{

    private TabLayout mTablayout; //顶部标题选项的布局
    private ViewPager mVp_main; //页签的ViewPager
    private ArrayList<FirstPagerFragment> mFragments; //存放Fragment的集合
    private String[] mTab_titlt; //存放标题（要闻 科技 那些）
    private MainTabAdapter mTabAdapter;  //标题的适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化 Fresco图片缓存框架
        Fresco.initialize(this);
        initData();
        initView();
    }

    private void initData() {
        mTab_titlt = getResources().getStringArray(R.array.tab_titlt);
        mFragments = new ArrayList<>();
        //创建相应的Fragment
        for (int i = 0; i < mTab_titlt.length; i++) {
            FirstPagerFragment firstPagerFragment = new FirstPagerFragment();
            mFragments.add(firstPagerFragment);
        }
    }

    private void initView() {
        mTablayout = (TabLayout) findViewById(R.id.Tablayout1);
        mVp_main = (ViewPager) findViewById(R.id.vp_main);
        mTabAdapter = new MainTabAdapter(getSupportFragmentManager(),mFragments,mTab_titlt);
        //为ViewPager设置适配器
        mVp_main.setAdapter(mTabAdapter);
        //将TabLayout 和ViewPager  绑定起来
        mTablayout.setupWithViewPager(mVp_main);
    }



}
