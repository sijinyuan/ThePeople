package bw.com.likqlibrary.mvp.ibase;

import android.os.Bundle;

/**
 * Created by xueh on 2016/11/8.
 */

public interface  IOnCreate {
    /**
     * 返回布局文件ID
     * @return
     */
     int bindLayout();
    /**
     * 初始化控件
     * @return
     */
    void initViews(Bundle savedInstanceState);
    /**
     * 初始化数据
     * @return
     */
    void initData();

    /**
     * 加载网络数据 在OnCreate方法中
     * @return
     */
    void loadData();
}
