package com.people.utils;

import com.people.bean.NewsBean;

import bw.com.likqlibrary.mvp.ibase.IBaseView;

/**
 * Created by Administrator on 2017/1/6.
 */
public class Contract {
    public interface  IBasePresenter{
        void getDataFirst();

    }
    public interface  INeFragment extends IBaseView {
        void getDataFirstSuccess(NewsBean newsBean);

    }
}
