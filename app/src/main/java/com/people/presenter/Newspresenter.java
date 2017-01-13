package com.people.presenter;

import com.people.bean.NewsBean;
import com.people.interfaces.MyCallBack;
import com.people.model.Newsmodel;
import com.people.utils.Contract;

import bw.com.likqlibrary.mvp.BasePresenter;

/**
 * Created by Administrator on 2017/1/6.
 */
public class Newspresenter extends BasePresenter<Newsmodel,Contract.INeFragment> implements Contract.IBasePresenter {


    public Newspresenter(Contract.INeFragment iNeFragment) {
        super(iNeFragment);
    }

    @Override
    protected Newsmodel createModel() {
        return new Newsmodel();
    }


    @Override
    public void getDataFirst() {
        getModel().getDataFirst(new MyCallBack() {
            @Override
            public void success(NewsBean newsBean) {
                getView().getDataFirstSuccess(newsBean);
            }

            @Override
            public void failure(String errMsg) {
                System.out.println("");
            }
        });

    }
}
