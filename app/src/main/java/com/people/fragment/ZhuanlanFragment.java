package com.people.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.people.R;
import com.people.adapter.ColumnAdapter;
import com.people.bean.ColumnBean;
import com.people.model.OkHttp;
import com.people.model.Tools;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

/**
 * Created by Administrator on 2017/1/6.
 */
public class ZhuanlanFragment extends Fragment {
    private RecyclerView coulumn;
    String mpath="http://news-at.zhihu.com/api/4/sections";
    private List<ColumnBean.DataBean> data;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=View.inflate(getActivity(), R.layout.fragment_zhuanlan,null);
         initData();
          return view;
    }

    private void initData() {
        initView();
        OkHttp.getAsync(mpath, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                ColumnBean columnbean= Tools.parseJsonWithGson(result,ColumnBean.class);
                         data = columnbean.getData();
                ColumnAdapter columnAdapter=new ColumnAdapter( getActivity(),data);
                coulumn.setAdapter(columnAdapter);



            }
        });
    }

    private void initView() {
        coulumn=(RecyclerView)view.findViewById(R.id.column);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        //设置布局管理器
        coulumn.setLayoutManager(layoutManager);
        //设置垂直的布局
        layoutManager.setOrientation(OrientationHelper.VERTICAL);

    }
}
