package Adapter;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import Fragment.FirstPagerFragment;

/**
 * 主页面 顶部标签的适配器
 * Created by Joker on 2016/9/26.
 */

public class MainTabAdapter extends FragmentPagerAdapter {

    private List<FirstPagerFragment> mList_fragment ;
    private String[] mList_titlt;

    public MainTabAdapter(FragmentManager fm,List<FirstPagerFragment> List_fragment,String[] List_titlt) {
        super(fm);
        mList_fragment = List_fragment ;
        mList_titlt = List_titlt;
    }

    @Override
    public FirstPagerFragment getItem(int position) {
        return mList_fragment.get(position);
    }

    @Override
    public int getCount() {
        return mList_fragment.size();
    }

    /*
    * 这个是设置页签标题*/
    @Override
    public CharSequence getPageTitle(int position) {
        return mList_titlt[position] ;
    }
}
