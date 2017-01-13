package com.people.adapter.viewholder;

import android.content.Context;
import android.view.View;

import com.people.R;
import com.people.bean.NewsBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import bw.com.likqlibrary.utils.glideutils.GlideImageLoader;

/**
 * Created by Administrator on 2017/1/6.
 */
public class NewsViewpagerHolder extends BaseViewHolder<NewsBean> {

    private ArrayList<String> titlelist;
    private ArrayList<String> imglist;
    List<NewsBean.TopStoriesBean> top_storiesbean;


    private final Banner banner;

    public NewsViewpagerHolder(View itemView) {
        super(itemView);
        banner = (Banner) itemView.findViewById(R.id.banner);


    }

    @Override
    public void setData(Context context, NewsBean newsBean) {
        titlelist=new ArrayList<String>();
        imglist=new ArrayList<String>();
        for (int i=0;i<newsBean.top_stories.size();i++){

            imglist.add(newsBean.top_stories.get(i).image);
            titlelist.add(newsBean.top_stories.get(i).title);

        }

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setBannerTitles(titlelist);
        banner.setBannerAnimation(Transformer.Accordion);
        banner.setImages(imglist).setImageLoader(new GlideImageLoader()).start();

    }
}

