package bw.com.likqlibrary.mvp;//package com.example.library.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bw.com.likqlibrary.mvp.base.BaseFragment;
import bw.com.likqlibrary.mvp.ibase.IBasePresenter;
import bw.com.likqlibrary.mvp.ibase.IBaseView;


/**
 * 类描述：MVP架构下的Fragment基类
 * 创建人：xueh
 * 创建时间：2016/7/6 10:32
 */
public abstract class MvpFragment<P extends IBasePresenter> extends BaseFragment implements IBaseView{

    protected P mPresenter;

    protected abstract P createPresenter(IBaseView view);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        mPresenter = createPresenter(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {

        if (null != mPresenter) {
            mPresenter.onDestroy();
        }
        super.onDestroy();
    }
    public P getPresenter() {
        return mPresenter;
    }


}
//
//public abstract class BaseMvpFragment<P extends IBasePresenter> extends
//        BaseFragment implements IBaseView {
//    private P mPresenter;
//    private Dialog mLoadingDialog;
//
//    protected abstract P createPresenter(IBaseView view);
//
//    @Override
//    public void initViews(Bundle savedInstanceState) {
//        mPresenter = createPresenter(this);
//        mLoadingDialog = getLoadingDialog();
//        if (mPresenter == null) {
//            throw new RuntimeException("presenter muse be in createPresenter");
//        }
//    }
//
//    public P getPresenter() {
//        return mPresenter;
//    }
//
//    protected Dialog getLoadingDialog() {
//        return new Dialog(getActivity());
//    }
//
//    @Override
//    public void showLoading() {
//        if (mLoadingDialog != null && !mLoadingDialog.isShowing())
//            mLoadingDialog.show();
//    }
//
//    @Override
//    public void hideLoading() {
//        if (mLoadingDialog != null && mLoadingDialog.isShowing())
//            mLoadingDialog.dismiss();
//    }
