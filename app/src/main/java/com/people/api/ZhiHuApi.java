package com.people.api;

import com.people.bean.NewsBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/6.
 */
public interface ZhiHuApi {

//
    /**
     * 最新日报
     */
    @GET("api/4/news/latest")
    Observable<NewsBean> getdata();
//
//    /**
//     * 专栏日报
//     */
//    @GET("sections")
//    Observable<SectionListBean> getSectionList();
//
//    /**
//     * 专栏日报详情
//     */
//    @GET("section/{id}")
//    Observable<SectionChildListBean> getSectionChildList(@Path("id") int id);
//
//
//    /**
//     * 日报详情
//     */
//    @GET("news/{id}")
//    Observable<ZhihuDetailBean> getDetailInfo(@Path("id") int id);

}
