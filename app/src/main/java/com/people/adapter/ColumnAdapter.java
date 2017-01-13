package com.people.adapter;

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
import com.people.bean.ColumnBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
public class ColumnAdapter extends RecyclerView.Adapter<ColumnAdapter.MyViewHolder> {

    private List<ColumnBean.DataBean> data;
     private Context mContext;
     private LayoutInflater inflater;

    public ColumnAdapter(Context mContext, List<ColumnBean.DataBean> data) {
        this.mContext = mContext;
        this.data = data;
        inflater=LayoutInflater.from(mContext);
    }
    //创新view,被LayoutManager所调用
    @Override
    public ColumnAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=inflater.inflate(R.layout.zhuanlanitem1,parent,false);
        MyViewHolder holder=new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ColumnAdapter.MyViewHolder holder, int position) {
        Glide.with(mContext)
                .load(data.get(position).getThumbnail())
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓冲全尺寸
                .centerCrop()//设置居中
                .placeholder(R.mipmap.ic_launcher)//设置占位图
                .error(R.mipmap.ic_launcher)//加载错误图
                .into(((MyViewHolder)holder).ColumnImg);
        holder.ColumnnTv.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private  ImageView ColumnImg;
        private TextView ColumnnTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ColumnImg =(ImageView)itemView.findViewById(R.id.imgcolumn);
            ColumnnTv=(TextView)itemView.findViewById(R.id.tvcolumn);

        }
    }
}
