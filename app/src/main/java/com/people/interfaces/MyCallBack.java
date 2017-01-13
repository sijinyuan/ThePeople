package com.people.interfaces;

import com.people.bean.NewsBean;

/**
 * Created by Administrator on 2017/1/6.
 */
public interface MyCallBack {


    void success(NewsBean list);

    void failure(String errMsg);

}
