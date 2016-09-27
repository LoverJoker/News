package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joker.news.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.List;

/**
 * Created by Joker on 2016/9/26.
 */

public class FirstPagerFragmetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int TYPE_HEAD = 0 ;
    private int TYPE_NORMAL = 1 ;
    private Context mContext;
    private List<String> mBannerUrl ;

    public FirstPagerFragmetAdapter(Context context,List<String> BannerUrl ){
        mContext = context;
        mBannerUrl = BannerUrl;
    }


    //创建对应的ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder  holder = null ;
        if (viewType == TYPE_HEAD){
            //表明创建头部Banner
            holder = new BannerHolder(LayoutInflater.from(mContext).inflate(R.layout.item_banner,
                    parent,false));
        }else {
            holder = new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.itm_normal,
                    parent,false)) ;
        }
        return holder;
    }


    //绑定ViewHolder
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  BannerHolder){
            BannerHolder Bholder = (BannerHolder) holder;
            Bholder.banner.setImages(mBannerUrl);
        }else if (holder instanceof ItemHolder){
            ItemHolder itemHolder  = (ItemHolder) holder;
            itemHolder.tv_item_normal.setText("这是测试用的文本");
            itemHolder.simpImg.setImageURI("http://v3.qzone.cc/pic/201407/20/16/23/53cb7c85eb7e3393.jpg!600x600.jpg");
        }
    }

    @Override
    public int getItemCount() {
        return mBannerUrl.size()+1;
    }


    /*
    * 告诉要创建什么类型的ViewHolder*/
    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPE_HEAD ;
        }else{
            return TYPE_NORMAL;
        }

    }

    /*
    * 正常的item*/
    class ItemHolder extends RecyclerView.ViewHolder{
        TextView tv_item_normal;
        SimpleDraweeView simpImg;

        public ItemHolder(View itemView) {
            super(itemView);
            tv_item_normal = (TextView) itemView.findViewById(R.id.tv_item_normal);
            simpImg = (SimpleDraweeView) itemView.findViewById(R.id.simpImg);
        }
    }

    /*
    * 标题轮播图*/
    class BannerHolder extends RecyclerView.ViewHolder{

        Banner banner;
        public BannerHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.img_banner);

        }
    }
}
