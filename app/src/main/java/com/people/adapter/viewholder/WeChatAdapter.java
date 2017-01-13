package com.people.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.people.R;
import com.people.bean.WeChatBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */
public class WeChatAdapter extends RecyclerView.Adapter<WeChatAdapter.MyViewHolder> {
    private List<WeChatBean.NewslistBean> newslist;
    private Context mContext;
    private LayoutInflater inflater;

    public WeChatAdapter(List<WeChatBean.NewslistBean> newslist, Context mContext) {
        this.newslist = newslist;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public WeChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.wechat_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(WeChatAdapter.MyViewHolder holder, int position) {
        Glide.with(mContext)
                .load(newslist.get(position).getPicUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓冲全尺寸
                .centerCrop()//设置居中
                .placeholder(R.mipmap.ic_launcher)//设置占位图
                .error(R.mipmap.ic_launcher)//加载错误图
                .into(((MyViewHolder)holder).imgchat);
        holder.chattitle.setText(newslist.get(position).getTitle());
        holder.chatfrom.setText(newslist.get(position).getDescription());
        holder.chattime.setText(newslist.get(position).getCtime());

    }

    @Override
    public int getItemCount() {
        return newslist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgchat;
        private TextView  chattitle;
        private TextView  chatfrom;
        private TextView chattime;

        public MyViewHolder(View itemView) {

            super(itemView);
            imgchat=(ImageView)itemView.findViewById(R.id.iv_wechat_item_image);
            chattitle=(TextView)itemView.findViewById(R.id.tv_wechat_item_title);
            chatfrom=(TextView)itemView.findViewById(R.id.tv_wechat_item_from);
            chattime=(TextView)itemView.findViewById(R.id.tv_wechat_item_time);
        }
    }
}
