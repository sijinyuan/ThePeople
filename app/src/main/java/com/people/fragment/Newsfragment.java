package com.people.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.people.R;
import com.people.adapter.NewsAdapter;
import com.people.bean.NewsBean;
import com.people.presenter.Newspresenter;
import com.people.utils.Contract;

import bw.com.likqlibrary.mvp.MvpFragment;
import bw.com.likqlibrary.mvp.ibase.IBaseView;

/**
 * Created by Administrator on 2017/1/6.
 */
public class Newsfragment extends MvpFragment<Newspresenter> implements Contract.INeFragment{

    private RecyclerView recyclerView;

    @Override
    protected Newspresenter createPresenter(IBaseView view) {
        return new Newspresenter(this);
    }

    @Override
    public void getDataFirstSuccess(NewsBean newsBean) {

        //设置适配器
        Log.e("dfsdf", "getDataFirstSuccess: ");
        NewsAdapter newsApapter = new NewsAdapter(newsBean,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newsApapter);
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        recyclerView = findview(R.id.news_recyclerview);

    }
    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        getPresenter().getDataFirst();
    }
}
