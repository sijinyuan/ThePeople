package com.people.model;

import com.people.api.ZhiHuApi;
import com.people.bean.NewsBean;
import com.people.interfaces.MyCallBack;
import com.people.model.Ibase.INewsmodel;

import bw.com.likqlibrary.mvp.BaseModel;
import bw.com.likqlibrary.netutils.ICallback;
import bw.com.likqlibrary.netutils.Retrofit2Helper;

/**
 * Created by Administrator on 2017/1/6.
 */
public class Newsmodel extends BaseModel<ZhiHuApi> implements INewsmodel {
    private String baseurl="http://news-at.zhihu.com/";

    public Newsmodel(){
        if (getApi()==null){
            ZhiHuApi api= Retrofit2Helper.getApi(baseurl,ZhiHuApi.class);
            setApi(api);

        }
    }

    @Override
    public void getDataFirst(final MyCallBack callBack) {
        deploy(getApi().getdata(), new ICallback<NewsBean>() {
            @Override
            public void onCompleted(NewsBean newsbean) {
                callBack.success(newsbean);
            }

            @Override
            public void onFailed(String errMsg) {
                System.out.println(errMsg);

            }
        });


    }
}

