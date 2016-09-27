package Utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * Created by Joker on 2016/9/27.
 */

public class JsonUtils {


    public void getResult(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //1:生成okHttpClient对象
                OkHttpClient Client = new OkHttpClient();
                //2:新建一个请求
                Request request = new Request.Builder().url("http://news.ifeng.com/").build();
                //3:执行请求获得相应
                Call call = Client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        //请求失败
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        //请求成功
                        if (response.isSuccessful()){
                            String Str = response.body().string();
                            Message message = new Message();
                            message.obj = Str ;
                            message.what = 1 ;
                            mHandler.sendMessage(message);
                        }
                    }
                });
            }
        }).start();
    }


    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                String str = msg.obj.toString();
                getJson(str);
            }
            super.handleMessage(msg);
        }
    };

    //将拿到的数据 截取成JSON  并且解析
    private void getJson(String str) {
        String json = null;
        if (str!=null){
            //截取
            json = str.substring(str.indexOf("[[{"), str.indexOf("}]]") + 3);
            Log.i("json",json);
        }
        //进行JSON的解析
        Parsejson(json);
    }

    private void Parsejson(String json) {

    }
}
