package view1;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

import com.example.joker.news.R;

/**
 * Created by Joker on 2016/9/26.
 */

public class commomProgressDialog extends Dialog {

    private TextView mTv_loading;

    public commomProgressDialog(Context context) {
        //调用父类方法中第二个方法是传入 自定义的样式
        super(context, R.style.commomDialog);

        setContentView(R.layout.commomprogressdialog);

        //设置位置在屏幕中央
        getWindow().getAttributes().gravity = Gravity.CENTER ;
    }

    public void setMessage(String msg) {
        mTv_loading = (TextView) findViewById(R.id.tv_loading);
        mTv_loading.setText(msg);
    }
}
