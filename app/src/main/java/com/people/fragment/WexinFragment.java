package com.people.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.people.R;
import com.people.adapter.viewholder.WeChatAdapter;
import com.people.bean.WeChatBean;
import com.people.model.OkHttp;
import com.people.model.Tools;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

/**
 * Created by Administrator on 2017/1/6.
 */
public class WexinFragment extends Fragment {
    private RecyclerView weChat;
    String mPath="http://api.tianapi.com/wxnew/?key=78926886d340296c5125405447aed227&num=20&page=1";
    private List<WeChatBean.NewslistBean> newslist;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view = View.inflate(getActivity(), R.layout.fragment_weixin,null);
         initData();
        return view;
    }

    private void initData() {
        initView();
        OkHttp.getAsync(mPath, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                WeChatBean weChatBean = Tools.parseJsonWithGson(result, WeChatBean.class);
                 newslist = weChatBean.getNewslist();
                WeChatAdapter adapter=new WeChatAdapter(newslist,getActivity());
                weChat.setAdapter(adapter);
            }
        });
    }

    private void initView() {
        weChat=(RecyclerView) view.findViewById(R.id.wechat);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        //设置布局管理器
        weChat.setLayoutManager(layoutManager);
        //设置垂直的布局
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
    }
}
