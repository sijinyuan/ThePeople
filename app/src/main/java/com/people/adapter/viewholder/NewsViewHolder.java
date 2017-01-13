package com.people.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.people.R;
import com.people.bean.NewsBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import bw.com.likqlibrary.imgload.ImgLoadUtils;

/**
 * Created by Administrator on 2017/1/6.
 */
public class NewsViewHolder extends BaseViewHolder<NewsBean>{

    private final RecyclerView recyclerView;
    private List<NewsBean.StoriesBean> storieslist;

    public NewsViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.news_recyclerview_item);

    }

    @Override
    public void setData(Context context, NewsBean newsBean) {

        storieslist=newsBean.stories;
        Log.e("sdfsdf", "setData: " );
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new CommonAdapter<NewsBean.StoriesBean>(context, R.layout.new_item,storieslist){



            @Override
            protected void convert(ViewHolder holder, NewsBean.StoriesBean storiesBean, int position) {
                holder.setText(R.id.new_item_tv,storiesBean.title);
                ImageView new_item_img=holder.getView(R.id.new_item_img);
                ImgLoadUtils.getInstance().Load(storiesBean.images.get(0),new_item_img);

            }
        });

    }
}
