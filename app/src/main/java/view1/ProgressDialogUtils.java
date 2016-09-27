package view1;

import android.app.Activity;

/**
 * Created by Joker on 2016/9/26.
 */

public class ProgressDialogUtils {

    private commomProgressDialog mDialog ;
    private Activity mActivity;
    //显示方法
    public void showProgressDialog(Activity activity, String msg){
        mActivity = activity;
        if (mDialog == null){
            mDialog = new commomProgressDialog(activity);
        }
        if (msg == null){
            msg = "正在加载..." ;
        }
        //如果activity没关闭  并且弹窗没显示
        if (!activity.isFinishing()&& !mDialog.isShowing()){
            mDialog.show();
        }
        mDialog.setMessage(msg);
    }

    //关闭方法

    public void closeProgressDialog(){
        if (mDialog != null && !mActivity.isFinishing()){
            mDialog.dismiss();
            mDialog = null;
        }
    }
}
