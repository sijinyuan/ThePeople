package com.people.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.people.R;
import com.people.adapter.viewholder.BaseViewHolder;
import com.people.adapter.viewholder.NewsViewHolder;
import com.people.adapter.viewholder.NewsViewpagerHolder;
import com.people.bean.NewsBean;

/**
 * Created by Administrator on 2017/1/6.
 */
public class NewsAdapter  extends RecyclerView.Adapter<BaseViewHolder<NewsBean>>{

    private NewsBean newsBean;
    private Context context;

    public static final int TYPE0 = 0;
    public static final int TYPE1 = 1;

    public NewsAdapter(NewsBean newsBean, Context context) {
        this.newsBean=newsBean;
        this.context=context;

    }

    @Override
    public BaseViewHolder<NewsBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case TYPE0 :
                Log.e("jdsan","qqqasda");
                return new NewsViewpagerHolder(LayoutInflater.from(context).inflate(R.layout.viewpager_item,parent,false));
            case TYPE1:
                Log.e("jdsan","asda");
                return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item,parent,false));


        }
        Log.e("jdsan","asda");
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<NewsBean> holder, int position) {
        holder.setData(context,newsBean);
        Log.e("zzz","stoyies"+newsBean.toString());

    }


    @Override
    public int getItemViewType(int position) {
        Log.e("jdsan","position"+position);
        if (position==0){
            Log.e("jdsan",""+TYPE0);
            return TYPE0;
        }else
        {
            Log.e("jdsan",""+TYPE1);
            return TYPE1;

        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

