package Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.news.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.FirstPagerFragmetAdapter;
import view1.ProgressDialogUtils;

/**
 * Created by Joker on 2016/9/26.
 */

public class FirstPagerFragment extends Fragment {


    private ProgressDialogUtils mDialogUtils;
    private FragmentActivity activity;
    private List<String> BannerUrl;
    private RecyclerView mReyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        ViewGroup vp = (ViewGroup) activity.findViewById(R.id.vp_main);
        View view = inflater.inflate(R.layout.fragment_main, vp, false);





        BannerUrl = new ArrayList<>();
        BannerUrl.add("http://v3.qzone.cc/pic/201407/20/16/23/53cb7c8d780c2447.jpg!600x600.jpg");
        BannerUrl.add("http://v3.qzone.cc/pic/201407/20/16/23/53cb7c85eb7e3393.jpg!600x600.jpg");
        BannerUrl.add("http://v3.qzone.cc/pic/201407/20/16/23/53cb7c8f6f2c4690.jpg!600x600.jpg");
        BannerUrl.add("http://v3.qzone.cc/pic/201407/20/16/23/53cb7c9d12163726.jpg!600x600.jpg");


        mReyclerView = (RecyclerView) view.findViewById(R.id.recy_main);
        mReyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FirstPagerFragmetAdapter firstPagerFragmetAdapter = new FirstPagerFragmetAdapter(activity, BannerUrl);
        mReyclerView.setAdapter(firstPagerFragmetAdapter);

        //TimeClock(); // 显示正在加载全屏弹窗的方法*/
        return view;
    }

    private void TimeClock() {
        mDialogUtils = new ProgressDialogUtils();
        mDialogUtils.showProgressDialog(activity , "正在加载...");
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mDialogUtils.closeProgressDialog();
                    }
                });
            }
        }.start();
    }
}
